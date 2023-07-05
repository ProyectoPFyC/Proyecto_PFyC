import finca._
import org.scalameter.{Key, Warmer, config}

val standardConfig = config(
  Key . exec .minWarmupRuns := 20 ,
  Key . exec .maxWarmupRuns := 40 ,
  Key . exec . benchRuns := 25 ,
  Key . verbose :=false
) withWarmer (Warmer.Default())

/**
 *            Casos de prueba
 */

val finca2 = Vector((10,3,4), (5,3,3), (2,2,1), (8,1,1), (6,4,2))
val finca5 = Vector((12,3,4), (1,7,4), (4,1,1), (11,6,1), (7,3,4), (13,3,2), (13,5,1), (11,2,1))
val finca6 = Vector((8,5,4), (12,9,4), (2,2,3), (6,3,1), (9,5,3), (14,2,4), (19,7,3), (19,1,2), (19,8,4), (2,1,3))

val riego2 = Vector(0, 1, 4, 2, 3)
val riego5 = Vector(4, 6, 2, 0, 5, 1, 3, 7)
val riego6 = Vector(4, 6, 2, 0, 5, 1, 3, 7, 8)

val distancia2 = Vector(Vector(0, 2, 2, 4, 4), Vector(2, 0, 4, 2, 6), Vector(2,4,0,2,2), Vector(4,2,2,0,4), Vector(4,6,2,4,0))
val distancia5 = Vector(Vector(0, 14, 15, 22, 11, 17, 3, 9), Vector(23, 0, 18, 1, 3, 20, 11, 14), Vector(15, 21, 0, 5, 15, 23, 11, 17), Vector(4, 6, 20, 0, 3, 8, 14, 20), Vector(9, 21, 5, 12, 0, 5, 16, 20), Vector(23, 20, 20, 24, 2, 0, 2, 15), Vector(3, 1, 6, 6, 21, 4, 0, 4), Vector(19, 23, 8, 7, 21, 14, 22, 0))
val distancia6 = Vector(Vector(0, 5, 4, 21, 3, 18, 15, 11, 2, 9), Vector(23, 0, 30, 28, 16, 25, 1, 7, 13, 9), Vector(30, 24, 0, 1, 30, 9, 7, 9, 10, 4), Vector(4, 18, 25, 0, 25, 5, 11, 18, 29, 7), Vector(9, 10, 17, 11, 0, 8, 20, 4, 23, 21), Vector(12, 7, 8, 22, 28, 0, 11, 24, 5, 12), Vector(26, 17, 25, 13, 28, 29, 0, 25, 9, 11), Vector(15, 17, 29, 3, 28, 25, 18, 0, 11, 28), Vector(10, 3, 19, 18, 10, 30, 26, 12, 0, 12), Vector(19, 25, 16, 4, 6, 1, 20, 15, 29, 0))

/**
 *            1
 */
//Pruebas tIR

val tIR1 = tIR(finca5, riego5)

//Pruebas costoRiegoTablon

val tCRT1 = costoRiegoTablon(2, finca5, riego5)
val tCRT2 = costoRiegoTablon(4, finca5, riego5)
val tCRT3 = costoRiegoTablon(7, finca5, riego5)

//Pruebas costoRiegoFinca

val tCRF1 = costoRiegoFinca(finca2, riego2)

//Pruebas costoMovilidad

val tCM1 = costoMovilidad(finca2, riego2 , distancia2)

/**
 *            2
 */

//Pruebas generarProgramacionesRiego
val gPR1 = generarProgramacionesRiego(finca2)
gPR1.length

//Pruebas programacionRiegoOptimo

val pRO = programacionRiegoOptimo(finca2, distancia2)

/**
 *            3
 */

//Pruebas costoRiegoFincaPar

val tCRF1Par = costoRiegoFincaPar(finca2, riego2)

//Pruebas costoMovilidadPar

val tCM1Par = costoMovilidadPar(finca2, riego2 , distancia2)

//Pruebas generarProgramacionesRiegoPar
val gPR1Par = generarProgramacionesRiegoPar(finca2)
gPR1Par.length

//Pruebas programacionRiegoOptimoPar

val pRO = programacionRiegoOptimoPar(finca2, distancia2)

//tiempos costoRiegoFinca
standardConfig measure {
  costoRiegoFinca(finca6, riego6)
}
standardConfig measure {
  costoRiegoFincaPar(finca6, riego6)
}

//tiempos costoMovilidad
standardConfig measure {
  costoMovilidad(finca6, riego6, distancia6)
}
standardConfig measure {
  costoMovilidadPar(finca6, riego6, distancia6)
}

//tiempos generarProgramacionesRiego
standardConfig measure {
  generarProgramacionesRiego(finca2)
}
standardConfig measure {
  generarProgramacionesRiegoPar(finca2)
}

//tiempos programacionRiegoOptimo
standardConfig measure {
  programacionRiegoOptimo(finca2, distancia2)
}
standardConfig measure {
  programacionRiegoOptimoPar(finca2, distancia2)
}

