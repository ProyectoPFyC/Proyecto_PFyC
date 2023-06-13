/**
 *            Integrantes:
 * Samuel Galindo - 2177491
 *
 *
 * Kevin Velez - 2123281
 */
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
      def calcularTR(par:Int): Int = {
        if (par == 0) {
          0
        }
        else {
          treg(f,pi(par-1)) + calcularTR(par-1)
        }
      }

      val parejaOrden = pi.zip(0 until pi.length).sortBy(_._1)
      Vector.tabulate(pi.length)(i => calcularTR(parejaOrden(i)._2))
    }
}
 def costoRiegoTablon(i: Int, f: Finca, pi: ProgRiego): Int = {
    val tiempoInicioRiego = tIR(f, pi) // Calcula el tiempo de inicio de riego para cada tablón según la programación pi
    val tiempoRiego = treg(f, i) // Tiempo que lleva regar el tablón i
    val prioridad = prio(f, i) // Prioridad del tablón i
    val tiempoSupervivencia = tsup(f, i) // Tiempo de supervivencia del tablón i

    // Calcula el costo de regar el tablón i
    val costo = tiempoInicioRiego(i) + tiempoRiego * prioridad + tiempoSupervivencia
    costo
  }

  def costoRiegoFinca(f: Finca, pi: ProgRiego): Int = {
    val tiempoInicioRiego = tIR(f, pi) // Calcula el tiempo de inicio de riego para cada tablón según la programación pi

    // Utiliza foldLeft para iterar sobre los índices de los tablones y acumular el costo de riego
    f.indices.foldLeft(0) { (acc, i) =>
      acc + costoRiegoTablon(i, f, pi) // Acumula el costo total sumando el costo de riego de cada tablón
    }
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
    val programaciones = generarProgramacionesRiego(f) // Generar todas las programaciones posibles
    val resultados = programaciones.map { pi =>
      val costoMov = costoMovilidad(f, pi, d) // Calcular el costo de movilidad para la programación pi
      (pi, costoMov) // Retornar la programación pi junto con su costo de movilidad
    }
    resultados.minBy(_._2) // Retornar la programación con el menor costo de movilidad
  }
