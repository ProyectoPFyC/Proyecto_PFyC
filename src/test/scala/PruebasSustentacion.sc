import finca._
import org.scalameter.{Key, Warmer, config}

import scala.util.Random

val standardConfig = config(
  Key . exec .minWarmupRuns := 20 ,
  Key . exec .maxWarmupRuns := 40 ,
  Key . exec . benchRuns := 25 ,
  Key . verbose :=false
) withWarmer (Warmer.Default())

/**
 *            Casos de prueba
 */

val finca1 = fincaAlAzar(2500)
val finca2 = Vector((12,3,4), (1,7,4), (4,1,1), (11,6,1), (7,3,4), (13,3,2), (13,5,1), (11,2,1))

val riego1 = Random.shuffle(Vector.tabulate(2500)(x => x))
val riego2 = Vector(4, 6, 2, 0, 5, 1, 3, 7)

val distancia1 = distanciaAlAzar(2500)
val distancia2 = Vector(Vector(0, 14, 15, 22, 11, 17, 3, 9), Vector(23, 0, 18, 1, 3, 20, 11, 14),
  Vector(15, 21, 0, 5, 15, 23, 11, 17), Vector(4, 6, 20, 0, 3, 8, 14, 20), Vector(9, 21, 5, 12, 0, 5, 16, 20), Vector(23, 20, 20, 24, 2, 0, 2, 15), Vector(3, 1, 6, 6, 21, 4, 0, 4), Vector(19, 23, 8, 7, 21, 14, 22, 0))

/**
 *            1
 */
//Pruebas tIR

val tIR1 = tIR(finca1, riego1)

//Pruebas costoRiegoTablon

val tCRT1 = costoRiegoTablon(500, finca1, riego1)

//Pruebas costoRiegoFinca

val tCRF1 = costoRiegoFinca(finca1, riego1)

//Pruebas costoMovilidad

val tCM1 = costoMovilidad(finca1, riego1 , distancia1)

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

val tCRF1Par = costoRiegoFincaPar(finca1, riego1)

//Pruebas costoMovilidadPar

val tCM1Par = costoMovilidadPar(finca1, riego1, distancia1)

//Pruebas generarProgramacionesRiegoPar
val gPR1Par = generarProgramacionesRiegoPar(finca2)
gPR1Par.length

//Pruebas programacionRiegoOptimoPar

val pRO = programacionRiegoOptimoPar(finca2, distancia2)

//tiempos costoRiegoFinca
standardConfig measure {
  costoRiegoFinca(finca1, riego1)
}
standardConfig measure {
  costoRiegoFincaPar(finca1, riego1)
}

//tiempos costoMovilidad
standardConfig measure {
  costoMovilidad(finca1, riego1, distancia1)
}
standardConfig measure {
  costoMovilidadPar(finca1, riego1, distancia1)
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

