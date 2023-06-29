

```
# Manual de Uso - Finca

El paquete `finca` proporciona funciones para gestionar una finca, programar el riego de los tablones y calcular los costos asociados al riego y la movilidad en la finca.

## Contenido

1. [Integrantes del equipo](#integrantes)
2. [Funciones disponibles](#funciones-disponibles)
3. [Uso de las funciones](#uso-de-las-funciones)
4. [Ejemplos de uso](#ejemplos-de-uso)

## Integrantes del equipo<a name="integrantes"></a>

- Samuel Galindo Cuevas - 2177491
- Ervin Caravali Ibarra - 1925648
- Jhoimar Silva Torres - 2177167
- Kevin Alejandro Vélez Agudelo - 2123281

## Funciones disponibles<a name="funciones-disponibles"></a>

El paquete `finca` proporciona las siguientes funciones:

- `fincaAlAzar(long: Int): Finca`: Crea una finca de longitud `long` con valores aleatorios para el tiempo de supervivencia, tiempo de riego y prioridad de cada tablón.
- `distanciaAlAzar(long: Int): Distancia`: Crea una matriz de distancias entre tablones para una finca de longitud `long` con valores aleatorios.
- `tsup(f: Finca, i: Int): Int`: Obtiene el tiempo de supervivencia del tablón `i` en la finca `f`.
- `treg(f: Finca, i: Int): Int`: Obtiene el tiempo de riego del tablón `i` en la finca `f`.
- `prio(f: Finca, i: Int): Int`: Obtiene la prioridad del tablón `i` en la finca `f`.
- `tIR(f: Finca, pi: ProgRiego): TiempolnicioRiego`: Calcula los tiempos de inicio de riego para cada tablón en la finca `f` según una programación de riego `pi`.
- `costoRiegoTablon(i: Int, f: Finca, pi: ProgRiego): Int`: Calcula el costo de riego para el tablón `i` en la finca `f` según una programación de riego `pi`.
- `costoRiegoFinca(f: Finca, pi: ProgRiego): Int`: Calcula el costo total de riego para una finca `f` según una programación de riego `pi`.
- `costoRiegoFincaPar(f: Finca, pi: ProgRiego): Int`: Calcula el costo total de riego de forma paralela para una finca `f` según una programación de riego `pi`.
- `costoMovilidad(f: Finca, pi: ProgRiego, d: Distancia): Int`: Calcula el costo de movilidad en la finca `f` según una programación de riego `pi` y una matriz de distancias `d`.
- `costoMovilidadPar(f: Finca, pi: ProgRiego, d: Distancia): Int`: Calcula el costo de movilidad de forma paralela en la finca `f`

 según una programación de riego `pi` y una matriz de distancias `d`.
- `generarProgramacionesRiego(f: Finca): Vector[ProgRiego]`: Genera todas las posibles programaciones de riego para una finca `f`.
- `generarProgramacionesRiegoPar(f: Finca): Vector[ProgRiego]`: Genera todas las posibles programaciones de riego de forma paralela para una finca `f`.
- `ProgramacionRiegoOptimo(f: Finca, d: Distancia): (ProgRiego, Int)`: Encuentra la programación de riego óptima y su costo total para una finca `f` y una matriz de distancias `d`.
- `ProgramacionRiegoOptimoPar(f: Finca, d: Distancia): (ProgRiego, Int)`: Encuentra la programación de riego óptima y su costo total de forma paralela para una finca `f` y una matriz de distancias `d`.

## Uso de las funciones<a name="uso-de-las-funciones"></a>

Para utilizar las funciones del paquete `finca`, se debe importar el paquete y las clases y tipos asociados:


import finca._
import finca.common.parallel
import scala.collection.parallel.CollectionConverters._
import scala.util.Random


A continuación, se pueden utilizar las funciones proporcionadas según las necesidades del programa.

## Ejemplos de uso<a name="ejemplos-de-uso"></a>

A continuación se presentan algunos ejemplos de uso de las funciones del paquete `finca`:

1. Crear una finca al azar:


val finca = fincaAlAzar(5)
println(finca)


2. Crear una matriz de distancias al azar:


val distancia = distanciaAlAzar(5)
println(distancia)

3. Obtener el tiempo de supervivencia de un tablón en la finca:


val tiempoSupervivencia = tsup(finca, 0)
println(tiempoSupervivencia)


4. Obtener el tiempo de riego de un tablón en la finca:


val tiempoRiego = treg(finca, 0)
println(tiempoRiego)


5. Obtener la prioridad de un tablón en la finca:


val prioridad = prio(finca, 0)
println(prioridad)


6. Calcular los tiempos de inicio de riego para una programación de riego en una finca:


val programacion = Vector(1, 0, 3, 2)
val tiemposInicioRiego = tIR(finca, programacion)
println(tiemposInicioRiego)


7. Calcular el costo de riego para un tablón en la finca y una programación de riego:


val costoRiego = costoRiegoTablon(0, finca, programacion)
println(costoRiego)


8. Calcular el costo total de riego para una finca y una programación de riego:


val costoTotalRiego = costoRiegoFinca(finca, programacion)
println(costoTotalRiego)


9. Calcular el costo total de riego de forma paralela para una finca y una programación de riego:


val costoTotalRiegoPar = costoRiegoFinca

Par(finca, programacion)
println(costoTotalRiegoPar)


10. Calcular el costo de movilidad

 para una finca, una programación de riego y una matriz de distancias:


val costoMovilidad = costoMovilidad(finca, programacion, distancia)
println(costoMovilidad)


11. Calcular el costo de movilidad de forma paralela para una finca, una programación de riego y una matriz de distancias:


val costoMovilidadPar = costoMovilidadPar(finca, programacion, distancia)
println(costoMovilidadPar)


12. Generar todas las posibles programaciones de riego para una finca:


val programaciones = generarProgramacionesRiego(finca)
println(programaciones)


13. Generar todas las posibles programaciones de riego de forma paralela para una finca:


val programacionesPar = generarProgramacionesRiegoPar(finca)
println(programacionesPar)


14. Obtener la programación de riego óptima y su costo total para una finca y una matriz de distancias:


val (programacionOptima, costoOptimo) = ProgramacionRiegoOptimo(finca, distancia)
println(programacionOptima)
println(costoOptimo)

15. Obtener la programación de riego óptima y su costo total de forma paralela para una finca y una matriz de distancias:


val (programacionOptimaPar, costoOptimoPar) = ProgramacionRiegoOptimoPar(finca, distancia)
println(programacionOptimaPar)
println(costoOptimoPar)


