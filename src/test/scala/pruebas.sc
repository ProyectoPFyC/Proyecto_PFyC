import finca._

val F1: Finca = Vector((10, 3, 4), (5, 3, 3), (2, 2, 1), (8, 1, 1), (6, 4, 2))
val F2: Finca = Vector((9, 3, 4), (5, 3, 3), (2, 2, 1), (8, 1, 1), (6, 4, 2))

val DF1: Distancia = Vector(
  Vector(0, 2, 2, 4, 4),
  Vector(2, 0, 4, 2, 6),
  Vector(2, 4, 0, 2, 2),
  Vector(4, 2, 2, 0, 4),
  Vector(4, 6, 2, 4, 0)
)
val DF2: Distancia = Vector(
  Vector(0, 2, 2, 4, 4),
  Vector(2, 0, 4, 2, 6),
  Vector(2, 4, 0, 2, 2),
  Vector(4, 2, 2, 0, 4),
  Vector(4, 6, 2, 4, 0)
)
val prog1: ProgRiego = Vector(0, 1, 4, 2, 3)
val prog2: ProgRiego = Vector(2, 1, 4, 3,0)

tIR(F1,prog1)
val CostoDeRiegoFinca: Int = costoRiegoFinca(F1, prog1)
val CostoDeMovilidad: Int = costoMovilidad(DF1, prog1)

tIR(F2,prog2)
val CostoDeRiegoFinca: Int = costoRiegoFinca(F2, prog2)
val CostoDeMovilidad: Int = costoMovilidad(DF2, prog2)


val programacionesF1 = generarProgramacionesRiego(F1)
val programacionesF2 = generarProgramacionesRiego(F2)

println("Programaciones de riego para F1:")
val outputF1: Seq[String] = for {
  prog <- programacionesF1
} yield prog.mkString(", ")
println(outputF1.mkString("\n"))
val tamaño1 = outputF1.length
println()

println("Programaciones de riego para F2:")
val outputF2: Seq[String] = for {
  prog <- programacionesF2
} yield prog.mkString(", ")
val tamaño1 = outputF2.length
println(outputF2.mkString("\n"))

val resultado1: (ProgRiego, Int) = ProgramacionRiegoOptimo(F1, DF1)
val resultado2: (ProgRiego, Int) = ProgramacionRiegoOptimo(F2, DF2)

