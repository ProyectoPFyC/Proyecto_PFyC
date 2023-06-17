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

  def fincaAlAzar(long: Int): Finca = {
    Vector.fill(long) {
      (random.nextInt(long * 2) + 1, random.nextInt(long) + 1, random.nextInt(4) + 1)
    }
  }

  def distanciaAlAzar(long: Int): Distancia = {
    val v = Vector.fill(long, long) { random.nextInt(long * 3) + 1 }
    Vector.tabulate(long, long) { (i, j) =>
      if (i < j) v(i)(j)
      else if (i == j) 0
      else v(j)(i)
    }
  }

  def tsup(f: Finca, i: Int): Int = f(i)._1

  def treg(f: Finca, i: Int): Int = f(i)._2

  def prio(f: Finca, i: Int): Int = f(i)._3


  def tIR(f: Finca, pi: ProgRiego): TiempoInicioRiego = {
    def acumulado(v: Vector[Int]): Vector[Int] = {
      v.scanLeft(0)(_ + _).zip(pi).sortBy(_._2).map(x => x._1)
    }

    val tiemposRiego = Vector.tabulate(pi.length - 1)(i => treg(f, pi(i)))
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
    def calcularCostoRiegoFinca(index: Int, acc: Int): Int = {
      if (index >= f.length) acc
      else {
        val costoTablon = costoRiegoTablon(index, f, pi)
        calcularCostoRiegoFinca(index + 1, acc + costoTablon)
      }
    }

    calcularCostoRiegoFinca(0, 0)
  }


  def costoMovilidad(df: Distancia, pi: ProgRiego): Int = {
    def calcularCostoMovilidad(indices: Vector[Int]): Int = indices match {
      case _ if indices.length <= 1 => 0
      case head +: next +: tail => df(head)(next) + calcularCostoMovilidad(next +: tail)
    }

    calcularCostoMovilidad(pi)
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
      indicesDisponibles.permutations.toVector.filter(esProgramacionValida(_, f))
    }
    generarProgramacionesRiegoRecursivo(f, indicesTablones)
  }

  def ProgramacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int) = {
    val programaciones = generarProgramacionesRiego(f)
    val costoProgramaciones = programaciones.map { pi =>
      val costoRiego = costoRiegoFinca(f, pi)
      val costoMov = costoMovilidad(d, pi)
      (pi, costoRiego + costoMov)
    }
    costoProgramaciones.minBy(_._2)
  }

}
