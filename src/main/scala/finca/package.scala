/****************************************
 *                Integrantes
 * Samuel Galindo - 2177491
 *
 *
 *
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


  def tIR(f: Finca, pi: ProgRiego): TiempolnicioRiego =
    {
      def calcularTR(i:Int): Int = {
        if (i == 0) i else treg(f,pi(i-1)) + calcularTR(i-1)
      }

      val parejaOrden = pi.zip(0 until pi.length).sortBy(_._1)
      Vector.tabulate(pi.length)(i => calcularTR(parejaOrden(i)._2))
    }

  def tIR2(f: Finca, pi: ProgRiego): TiempolnicioRiego = {
      def acumulado(v: Vector[Int]): Vector[Int] ={
        v.scanLeft(0)(_+_).zip(pi).sortBy(_._2).map(x=> x._1)
      }

    val tiemposRiego = Vector.tabulate(pi.length-1)(i => treg(f, pi(i)))
    acumulado(tiemposRiego)
  }

  def costoRiegoTablon(i:Int, f:Finca, pi: ProgRiego): Int =
    {
      val tiemposRiego = tIR(f, pi)
      val sup = tsup(f,i)
      val reg = treg(f,i)
      val tRiego = tiemposRiego(i)

      if((sup - reg) >= tRiego) sup-(tRiego + reg) else prio(f,i) * ((tRiego + reg) - sup)
    }

  def costoRiegoFinca(f:Finca, pi: ProgRiego): Int =
  {
    val riegos = for (x <- 0 until pi.length) yield costoRiegoTablon(x, f, pi)
    riegos.foldLeft(0)((x, y) => x + y)
  }

  def costoRiegoFinca2(f: Finca, pi: ProgRiego): Int = {
    (for (x <- 0 until pi.length) yield costoRiegoTablon(x, f, pi)).foldLeft(0)((x, y) => x + y)
  }

  def costoRiegoFinca2Par(f: Finca, pi: ProgRiego): Int = {
    (for (x <- 0 until pi.length) yield costoRiegoTablon(x, f, pi)).par.foldLeft(0)((x, y) => x + y)
  }

  def costoMovilidad(f: Finca, pi: ProgRiego, d: Distancia): Int = {
      val costos = for(x <- 0 until pi.length-1) yield d(pi(x))(pi(x+1))
      costos.foldLeft(0)((x,y) => x+y)
  }

  def costoMovilidad2(f: Finca, pi: ProgRiego, d: Distancia): Int = {
    (for (x <- 0 until pi.length - 1) yield d(pi(x))(pi(x + 1))).foldLeft(0)((x, y) => x + y)
  }

  def costoMovilidad2Par(f: Finca, pi: ProgRiego, d: Distancia): Int = {
    (for (x <- 0 until pi.length - 1) yield d(pi(x))(pi(x + 1))).par.foldLeft(0)((x, y) => x + y)
  }

  def generarProgramacionesRiego(f: Finca): Vector[ProgRiego] = {
    val n = f.length // Tamaño de la finca
    // Función auxiliar recursiva para generar todas las permutaciones
    def generarPermutaciones(acc: Vector[ProgRiego], disponibles: Vector[Int], parcial: ProgRiego): Vector[ProgRiego] = {
      if (disponibles.isEmpty) {
        acc :+ parcial // Agregar la permutación parcial al resultado
      } else {
        disponibles.flatMap { i =>
          val nuevaPermutacion = parcial :+ i // Agregar el siguiente número a la permutación parcial
          val nuevosDisponibles = disponibles.filter(_ != i) // Eliminar el número usado de los disponibles
          generarPermutaciones(acc, nuevosDisponibles, nuevaPermutacion) // Llamada recursiva con la permutación parcial actualizada
        }
      }
    }

    val disponibles = Vector.tabulate(n)(identity) // Vector de números del 0 al (n-1)
    generarPermutaciones(Vector.empty, disponibles, Vector.empty) // Llamada inicial a la función auxiliar
  }

  def ProgramacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int) = {
    val programaciones = generarProgramacionesRiego(f) // Generar todas las programaciones posibles para la finca aleatoria
    val resultados = programaciones.map { pi =>
      val costoRiego = costoRiegoFinca(f, pi) // Calcular el costo de riego para la programación pi en la finca aleatoria
      val costoMov = costoMovilidad(f, pi, d) // Calcular el costo de movilidad para la programación pi en la finca aleatoria
      (pi, costoRiego + costoMov) // Retornar la programación pi junto con su costo total en la finca aleatoria
    }
    resultados.minBy(_._2) // Retornar la programación con el menor costo total (costo de riego + costo de movilidad) en la finca aleatoria
  }
}

