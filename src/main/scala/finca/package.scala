package object finca {

  import scala.util.Random

  // Un tablón es una tripleta con el tiempo de supervivencia, el tiempo de riego y la prioridad del tablón.
  type Tablon = (Int, Int, Int)

  // Una finca es un vector de tablones.
  type Finca = Vector[Tablon]

  // La distancia entre dos tablones se representa por una matriz.
  type Distancia = Vector[Vector[Int]]

  // Una programación de riego es un vector que asocia cada tablón con su turno de riego.
  type ProgRiego = Vector[Int]

  // El tiempo de inicio de riego es un vector que asocia cada tablón con el momento en que se riega.
  type TiempoInicioRiego = Vector[Int]

  val random = new Random()

  // Función para generar una finca aleatoria de longitud "long"
  def fincaAlAzar(long: Int): Finca = {
    Vector.fill(long) {
      (random.nextInt(long * 2) + 1, random.nextInt(long) + 1, random.nextInt(4) + 1)
    }
  }

  // Función para generar una matriz de distancias aleatoria de tamaño "long"
  def distanciaAlAzar(long: Int): Distancia = {
    val v = Vector.fill(long, long) { random.nextInt(long * 3) + 1 }
    Vector.tabulate(long, long) { (i, j) =>
      if (i < j) v(i)(j)
      else if (i == j) 0
      else v(j)(i)
    }
  }

  // Funciones auxiliares para obtener los valores individuales de un tablón
  def tsup(f: Finca, i: Int): Int = f(i)._1
  def treg(f: Finca, i: Int): Int = f(i)._2
  def prio(f: Finca, i: Int): Int = f(i)._3

  // Función para calcular los tiempos de inicio de riego para cada tablón en una programación de riego dada
  def tIR(f: Finca, pi: ProgRiego): TiempoInicioRiego = {
    def acumulado(v: Vector[Int]): Vector[Int] = {
      v.scanLeft(0)(_ + _).zip(pi).sortBy(_._2).map(x => x._1)
    }

    val tiemposRiego = Vector.tabulate(pi.length - 1)(i => treg(f, pi(i)))
    acumulado(tiemposRiego)
  }

  // Función para calcular el costo de riego de un tablón en una finca y una programación de riego dadas
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

  // Función para calcular el costo de riego de toda la finca en una programación de riego dada
  def costoRiegoFinca(f: Finca, pi: ProgRiego): Int = {
    def calcularCostoRiegoFinca(index: Int, acc: Int): Int = {
      if (index >= f.length) acc
      else {
        val costoTablon = costoRiegoTablon(index, f, pi)
        calcularCostoRiegoFinca(index + 1, acc + costoTablon)
      }
    }

    calcularCostoRiegoFinca(0, 0)
  }

  // Función para calcular el costo de movilidad de una programación de riego dada en una matriz de distancias dada
  def costoMovilidad(df: Distancia, pi: ProgRiego): Int = {
    def calcularCostoMovilidad(indices: Vector[Int]): Int = indices match {
      case _ if indices.length <= 1 => 0
      case head +: next +: tail => df(head)(next) + calcularCostoMovilidad(next +: tail)
    }

    calcularCostoMovilidad(pi)
  }

  // Función para generar todas las posibles programaciones de riego para una finca dada
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

  // Función para encontrar la programación de riego óptima para una finca y una matriz de distancias dadas
  def ProgramacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int) = {
    val programaciones = generarProgramacionesRiego(f)
    val resultados = programaciones.map { pi =>
      val costoRiego = costoRiegoFinca(f, pi)
      val costoMov = costoMovilidad(d, pi)
      (pi, costoRiego + costoMov)
    }
    resultados.minBy(_._2)
  }

}
