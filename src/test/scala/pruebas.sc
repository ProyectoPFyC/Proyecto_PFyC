import finca._

val finca1 = Vector(new Tablon(10,3,4), new Tablon(5,3,3), new Tablon(2,2,1), new Tablon(8,1,1), new Tablon(6,4,2))
val prog1 = Vector(0,1,4,2,3)
val distancia1 = Vector(Vector(0,2,2,4,4), Vector(2,0,4,2,6), Vector(2,4,0,2,2), Vector(4,2,2,0,4), Vector(4,6,2,4,0))

tIR2(finca1,prog1)
costoRiegoTablon2(2,finca1,prog1)

costoRiegoFinca2Par(finca1,prog1)
costoMovilidad2Par(finca1, prog1, distancia1)

