import finca._
import org.scalameter.{Key, Warmer, config}

val standardConfig = config(
  Key . exec .minWarmupRuns := 20 ,
  Key . exec .maxWarmupRuns := 40 ,
  Key . exec . benchRuns := 25 ,
  Key . verbose :=false
) withWarmer (Warmer.Default())

val finca1 = Vector(new Tablon(10,3,4), new Tablon(5,3,3), new Tablon(2,2,1), new Tablon(8,1,1), new Tablon(6,4,2))
val prog1 = Vector(0,1,4,2,3)
val distancia1 = Vector(Vector(0,2,2,4,4), Vector(2,0,4,2,6), Vector(2,4,0,2,2), Vector(4,2,2,0,4), Vector(4,6,2,4,0))

val finca2 = fincaAlAzar(8)
val distancia2 = distanciaAlAzar(8)
val prog2 = Vector(0,1,2,4,5,6,7,3)

tIR(finca1, prog1)

costoRiegoFinca(finca1,prog1)

costoMovilidad(finca1, prog1, distancia1)
//costoMovilidadPar(finca1, prog1, distancia1)

generarProgramacionesRiego(finca1)



standardConfig measure {
  costoMovilidad(finca2, prog2, distancia2)
}

standardConfig measure {
  costoMovilidad(finca2, prog2, distancia2)
}


