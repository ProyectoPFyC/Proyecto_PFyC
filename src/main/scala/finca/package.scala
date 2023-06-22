/**
 *            Integrantes:
 * Samuel Galindo - 2177491
 *
 *
 * Kevin Velez - 2123281
 */

//import common._

import scala.collection.parallel.CollectionConverters.ImmutableIterableIsParallelizable
import scala.util.Random
package object finca
{
  // Un tablon es una tripleta con el tiempo de supervivencia
  // el tiempo de riego y la prioridad del tablon
  type Tablon = (Int, Int, Int)

  // Una finca es un vector de tablones
  type Finca = Vector [Tablon]
  // si f:Finca, f(i) = (ts-i, tri, p-i)

  // La distancia entre dos tablones se representa por
  // una matriz
  type Distancia = Vector[Vector[Int]]

  // Una programacion de riego es un vector que asocia

  // cada tablon icon su turno de riego (0 es el primer turno
  // n= es el ultimo turno)

  type ProgRiego = Vector[Int]

  // si v:ProgRiego, y v.length==n, v es una permutacion

  // de £0,...,n—1) v(i) es el turno de riego del tablon i
  // para O<=i<n

  // El tiempo de inicio de riego es un vector que asocia
  // cada tablon i con el momento del tiempo en que se riega
  type TiempolnicioRiego = Vector[Int]

  // si t:TiempilnicioRiego y t.length==n, t(i) es la hora a
  // la que inicia a regarse el tablon i

  val random = new Random()

  def fincaAlAzar(long: Int): Finca = {

    //Crea una finca de long tablones,
    // con valores aleatorios entre 1 y long+2 para el tiempd
    // de superviviencia entre 1 y long para el tiempo
    // de regado y entre 1 y 4 para la prioridad
    val v = Vector.fill(long) {

      (random.nextInt(long * 2) + 1,

        random.nextInt(long) + 1,

        random.nextInt(4) + 1)
    }
    v
  }

  def distanciaAlAzar(long: Int): Distancia = {
  //Crea una matriz de distancias para una finca
  // de long tablones, con valores aleatorios entre
  // 1 y long+3
  val v = Vector.fill(long, long) {

    random.nextInt(long * 3) + 1
  }
    Vector.tabulate(long, long)(
    (i, j) => if (i < i) v(i)(j)
              else if (i == j) 0
              else v(j)(i))
  }
  def tsup(f: Finca, i: Int): Int = {
    f(i)._1
  }

  def treg(f: Finca, i: Int): Int = {
    f(i)._2
  }

  def prio(f: Finca, i: Int): Int = {
    f(i)._3
  }


  def tIR(f: Finca, pi: ProgRiego): TiempolnicioRiego = {
      def acumulado(v: Vector[Int]): Vector[Int] ={
        v.scanLeft(0)(_+_).zip(pi).sortBy(_._2).map(x=> x._1)
      }

    val tiemposRiego = Vector.tabulate(pi.length-1)(i => treg(f, pi(i)))
    acumulado(tiemposRiego)
  }

  def costoRiegoTablon(i: Int, f: Finca, pi: ProgRiego): Int = {
    val tiemposRiego = tIR(f, pi)
    val sup = tsup(f, i)
    val reg = treg(f, i)
    val tRiego = tiemposRiego(i)

    (sup - reg) match {
      case diff if diff >= tRiego => sup - (tRiego + reg)
      case _ => prio(f, i) * ((tRiego + reg) - sup)
    }
  }

  def costoRiegoFinca(f: Finca, pi: ProgRiego): Int = {
    Vector.tabulate(f.length)(i => costoRiegoTablon(i,f,pi)).foldLeft(0)((x, y) => x + y)
  }

  def costoRiegoFincaPar(f: Finca, pi: ProgRiego): Int = {
    Vector.tabulate(f.length)(i => costoRiegoTablon(i, f, pi)).par.foldLeft(0)((x, y) => x + y)
  }

  def costoMovilidad(f: Finca, pi: ProgRiego, d: Distancia): Int = {
    Vector.tabulate(f.length-1)(i=> d(pi(i))(pi(i + 1))).foldLeft(0)((x, y) => x + y)
  }

  def costoMovilidadPar(f: Finca, pi: ProgRiego, d: Distancia): Int = {
    Vector.tabulate(f.length-1)(i=> d(pi(i))(pi(i + 1))).par.foldLeft(0)((x, y) => x + y)
  }


   def generarProgramacionesRiego(f: Finca): Vector[ProgRiego] = {
    def esProgramacionValida(programacion: ProgRiego, f: Finca): Boolean = {
      val tiemposRiego = tIR(f, programacion)

      val condicion1 = tiemposRiego.distinct.length == tiemposRiego.length
      val condicion2 = tiemposRiego.zip(programacion).foldLeft(0)((acc, pair) => acc + treg(f, pair._2)) >= tiemposRiego.max

      condicion1 && condicion2
    }

    val indicesTablones = f.indices.toVector

    def generarProgramacionesRiegoRecursivo(f: Finca, indicesDisponibles: Vector[Int]): Vector[ProgRiego] = {
      if (indicesDisponibles.isEmpty) {
        Vector.empty
      } else if (indicesDisponibles.length == 1) {
        val programacion = Vector(indicesDisponibles.head)
        if (esProgramacionValida(programacion, f)) Vector(programacion) else Vector.empty
      } else {
        indicesDisponibles.flatMap { indice =>
          val restoIndices = indicesDisponibles.filter(_ != indice)
          generarProgramacionesRiegoRecursivo(f, restoIndices).map(indice +: _)
        }.filter(esProgramacionValida(_, f))
      }
    }

    generarProgramacionesRiegoRecursivo(f, indicesTablones)
  }

  import scala.collection.parallel.CollectionConverters._

  def generarProgramacionesRiegoPar(f: Finca): Vector[ProgRiego] = {
    def esProgramacionValida(programacion: ProgRiego, f: Finca): Boolean = {
      val tiemposRiego = tIR(f, programacion)

      val condicion1 = tiemposRiego.distinct.length == tiemposRiego.length
      val condicion2 = tiemposRiego.zip(programacion).foldLeft(0)((acc, pair) => acc + treg(f, pair._2)) >= tiemposRiego.max

      condicion1 && condicion2
    }

    val indicesTablones = f.indices.toList

    def generarProgramacionesRiegoRecursivos(indicesDisponibles: List[Int]): Vector[ProgRiego] = {
      indicesDisponibles match {
        case Nil => Vector.empty
        case indice :: Nil =>
          val programacion = Vector(indice)
          if (esProgramacionValida(programacion, f)) Vector(programacion) else Vector.empty
        case _ =>
          indicesDisponibles.toVector.par.flatMap { indice =>
            val restoIndices = indicesDisponibles.filterNot(_ == indice)
            val subprogramaciones = generarProgramacionesRiegoRecursivos(restoIndices)
            subprogramaciones.map(indice +: _)
          }.filter(esProgramacionValida(_, f)).toVector
      }
    }

    generarProgramacionesRiegoRecursivos(indicesTablones)
  }

  def ProgramacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int) = {
    val programaciones = generarProgramacionesRiego(f)
    val costoProgramaciones = programaciones.map { pi =>
      val costoRiego = costoRiegoFinca(f, pi)
      val costoMov = costoMovilidad(f, pi, d)
      (pi, costoRiego + costoMov)
    }
    costoProgramaciones.minBy(_._2)
  }
}
