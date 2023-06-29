import finca._

val finca0 = Vector((5,2,3), (6,3,3), (3,3,2))
val finca1 = Vector((5,2,4), (4,1,2), (2,3,3), (5,4,2))
val finca2 = Vector((10,3,4), (5,3,3), (2,2,1), (8,1,1), (6,4,2))
val finca3 = Vector((11,3,3), (7,3,3), (5,1,3), (5,5,3), (10,6,1), (10,3,1))
val finca4 = Vector((9,4,4), (1,5,4), (1,4,1), (10,3,2), (1,6,1), (8,7,2), (4,6,3))
val finca5 = Vector((12,3,4), (1,7,4), (4,1,1), (11,6,1), (7,3,4), (13,3,2), (13,5,1), (11,2,1))
val finca6 = Vector((8,5,4), (12,9,4), (2,2,3), (6,3,1), (9,5,3), (14,2,4), (19,7,3), (19,1,2), (19,8,4), (2,1,3))
val finca7 = Vector((4,7,4), (4,11,1), (20,7,2), (16,10,4), (2,5,2), (6,9,2), (23,2,4), (7,11,1), (22,8,1), (22,5,4), (21,10,1), (14,12,2))
val finca8 = Vector((25,13,4), (2,7,4), (8,7,1), (7,5,4), (10,4,4), (19,10,3), (5,4,2), (10,7,3), (10,9,2), (25,13,2), (13,10,3), (8,2,3), (14,12,1))

val riego0 = Vector(2, 0, 1)
val riego1 = Vector(1, 0, 3, 2)
val riego2 = Vector(0, 1, 4, 2, 3)
val rieg3 = Vector(2, 5, 4, 1, 0, 3)
val riego4 = Vector(6, 4, 2, 1, 3, 5, 0)
val riego5 = Vector(4, 6, 2, 0, 5, 1, 3, 7)
val riego6 = Vector(4, 8, 1, 3, 2, 7, 0, 5, 9, 6)
val riego7 = Vector(1, 10, 6, 8, 9, 7, 3, 0, 5, 4, 11, 2)
val riego8 = Vector(7, 10, 1, 9, 6, 11, 2, 0, 12, 8, 5, 3, 4)

val distancia0 = Vector(Vector(0, 1, 3), Vector(4, 0, 2), Vector(5, 7, 0))
val distancia1 = Vector(Vector(0, 8, 7, 8), Vector(5, 0, 10, 8), Vector(1, 10, 0, 10), Vector(4, 3, 8, 0))
val distancia2 = Vector(Vector(0,2,2,4,4), Vector(2,0,4,2,6), Vector(2,4,0,2,2), Vector(4,2,2,0,4), Vector(4,6,2,4,0))
val distancia3 = Vector(Vector(0, 5, 2, 16, 7, 6), Vector(18, 0, 10, 3, 9, 12), Vector(12, 10, 0, 13, 5, 16), Vector(15, 10, 2, 0, 8, 13), Vector(8, 4, 13, 12, 0, 17), Vector(3, 14, 7, 3, 12, 0))
val distancia4 = Vector(Vector(0, 5, 13, 15, 5, 14, 16), Vector(20, 0, 12, 6, 7, 10, 12), Vector(6, 2, 0, 13, 4, 3, 20), Vector(1, 14, 18, 0, 1, 15, 10), Vector(16, 19, 16, 11, 0, 1, 9), Vector(3, 13, 12, 16, 8, 0, 21), Vector(15, 18, 5, 20, 12, 5, 0))
val distancia5 = Vector(Vector(0, 14, 15, 22, 11, 17, 3, 9), Vector(23, 0, 18, 1, 3, 20, 11, 14), Vector(15, 21, 0, 5, 15, 23, 11, 17), Vector(4, 6, 20, 0, 3, 8, 14, 20), Vector(9, 21, 5, 12, 0, 5, 16, 20), Vector(23, 20, 20, 24, 2, 0, 2, 15), Vector(3, 1, 6, 6, 21, 4, 0, 4), Vector(19, 23, 8, 7, 21, 14, 22, 0))
val distancia6 = Vector(Vector(0, 5, 4, 21, 3, 18, 15, 11, 2, 9), Vector(23, 0, 30, 28, 16, 25, 1, 7, 13, 9), Vector(30, 24, 0, 1, 30, 9, 7, 9, 10, 4), Vector(4, 18, 25, 0, 25, 5, 11, 18, 29, 7), Vector(9, 10, 17, 11, 0, 8, 20, 4, 23, 21), Vector(12, 7, 8, 22, 28, 0, 11, 24, 5, 12), Vector(26, 17, 25, 13, 28, 29, 0, 25, 9, 11), Vector(15, 17, 29, 3, 28, 25, 18, 0, 11, 28), Vector(10, 3, 19, 18, 10, 30, 26, 12, 0, 12), Vector(19, 25, 16, 4, 6, 1, 20, 15, 29, 0))
val distancia7 = Vector(Vector(0, 30, 22, 5, 23, 29, 1, 25, 31, 16, 2, 11), Vector(2, 0, 25, 25, 36, 30, 31, 27, 33, 32, 10, 3), Vector(36, 15, 0, 25, 30, 2, 17, 26, 14, 34, 7, 12), Vector(30, 34, 20, 0, 33, 7, 20, 24, 28, 27, 16, 7), Vector(15, 26, 10, 8, 0, 21, 24, 14, 22, 15, 10, 27), Vector(29, 16, 17, 25, 28, 0, 12, 33, 28, 33, 18, 6), Vector(36, 18, 24, 11, 34, 32, 0, 28, 17, 14, 12, 30), Vector(12, 7, 28, 17, 21, 28, 28, 0, 29, 14, 16, 26), Vector(15, 10, 12, 32, 16, 6, 14, 1, 0, 19, 12, 24), Vector(7, 26, 19, 27, 12, 19, 29, 7, 7, 0, 3, 18), Vector(28, 30, 21, 31, 27, 11, 18, 3, 6, 28, 0, 7), Vector(22, 24, 28, 7, 9, 14, 33, 32, 27, 8, 15, 0))
val distancia8 = Vector(Vector(0, 16, 26, 23, 8, 32, 4, 36, 27, 36, 13, 7, 16), Vector(9, 0, 16, 24, 29, 25, 36, 39, 22, 18, 36, 25, 31), Vector(32, 26, 0, 37, 31, 26, 18, 30, 20, 10, 13, 27, 36), Vector(21, 5, 35, 0, 13, 37, 2, 36, 8, 5, 13, 21, 22), Vector(28, 3, 25, 25, 0, 2, 17, 12, 14, 19, 8, 33, 1), Vector(36, 20, 15, 17, 9, 0, 21, 36, 18, 9, 3, 38, 34), Vector(39, 26, 33, 2, 16, 34, 0, 28, 16, 10, 37, 4, 13), Vector(21, 15, 26, 6, 9, 16, 4, 0, 33, 25, 1, 17, 38), Vector(19, 2, 24, 18, 25, 14, 4, 21, 0, 4, 14, 33, 4), Vector(14, 9, 22, 31, 38, 12, 20, 29, 17, 0, 27, 19, 8), Vector(7, 24, 10, 22, 5, 29, 27, 25, 38, 15, 0, 10, 10), Vector(23, 28, 12, 21, 12, 24, 27, 20, 23, 9, 36, 0, 22), Vector(23, 21, 23, 2, 25, 1, 17, 3, 36, 20, 35, 3, 0))


//generarProgramacionesRiegoPar
// Finca 0
generarProgramacionesRiegoPar(finca0)
//val res0: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2), Vector(0, 2, 1), Vector(1, 0, 2), Vector(1, 2, 0), Vector(2, 0, 1), Vector(2, 1, 0))
// Finca 1
generarProgramacionesRiegoPar(finca1)
//val res1: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3), Vector(0, 1, 3, 2), Vector(0, 2, 1, 3), Vector(0, 2, 3, 1), Vector(0, 3, 1, 2), Vector(0, 3, 2, 1), Vector(1, 0, 2, 3), Vector(1, 0, 3, 2), Vector(1, 2, 0, 3), Vector(1, 2, 3, 0), Vector(1, 3, 0, 2), Vector(1, 3, 2, 0), Vector(2, 0, 1, 3), Vector(2, 0, 3, 1), Vector(2, 1, 0, 3), Vector(2, 1, 3, 0), Vector(2, 3, 0, 1), Vector(2, 3, 1, 0), Vector(3, 0, 1, 2), Vector(3, 0, 2, 1), Vector(3, 1, 0, 2), Vector(3, 1, 2, 0), Vector(3, 2, 0, 1), Vector(3, 2, 1, 0))
// Finca 2
generarProgramacionesRiegoPar(finca2)
//val res2: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4), Vector(0, 1, 2, 4, 3), Vector(0, 1, 3, 2, 4), Vector(0, 1, 3, 4, 2), Vector(0, 1, 4, 2, 3), Vector(0, 1, 4, 3, 2), Vector(0, 2, 1, 3, 4), Vector(0, 2, 1, 4, 3), Vector(0, 2, 3, 1, 4), Vector(0, 2, 3, 4, 1), Vector(0, 2, 4, 1, 3), Vector(0, 2, 4, 3, 1), Vector(0, 3, 1, 2, 4), Vector(0, 3, 1, 4, 2), Vector(0, 3, 2, 1, 4), Vector(0, 3, 2, 4, 1), Vector(0, 3, 4, 1, 2), Vector(0, 3, 4, 2, 1), Vector(0, 4, 1, 2, 3), Vector(0, 4, 1, 3, 2), Vector(0, 4, 2, 1, 3), Vector(0, 4, 2, 3, 1), Vector(0, 4, 3, 1, 2), Vector(0, 4, 3, 2, 1), Vector(1, 0, 2, 3, 4), Vector(1, 0, 2, 4, 3), Vector(1, 0, 3, 2, 4), Vector(1, 0, 3, 4, 2), Vector(1, 0, 4, 2, 3), Vector(1, 0, 4, 3, 2), Vector(1, 2, 0, 3, 4), Vector(1, 2, 0, 4, 3), Vector(1, 2, 3, 0,...
// Finca 3
generarProgramacionesRiegoPar(finca3)
//val res3: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5), Vector(0, 1, 2, 3, 5, 4), Vector(0, 1, 2, 4, 3, 5), Vector(0, 1, 2, 4, 5, 3), Vector(0, 1, 2, 5, 3, 4), Vector(0, 1, 2, 5, 4, 3), Vector(0, 1, 3, 2, 4, 5), Vector(0, 1, 3, 2, 5, 4), Vector(0, 1, 3, 4, 2, 5), Vector(0, 1, 3, 4, 5, 2), Vector(0, 1, 3, 5, 2, 4), Vector(0, 1, 3, 5, 4, 2), Vector(0, 1, 4, 2, 3, 5), Vector(0, 1, 4, 2, 5, 3), Vector(0, 1, 4, 3, 2, 5), Vector(0, 1, 4, 3, 5, 2), Vector(0, 1, 4, 5, 2, 3), Vector(0, 1, 4, 5, 3, 2), Vector(0, 1, 5, 2, 3, 4), Vector(0, 1, 5, 2, 4, 3), Vector(0, 1, 5, 3, 2, 4), Vector(0, 1, 5, 3, 4, 2), Vector(0, 1, 5, 4, 2, 3), Vector(0, 1, 5, 4, 3, 2), Vector(0, 2, 1, 3, 4, 5), Vector(0, 2, 1, 3, 5, 4), Vector(0, 2, 1, 4, 3, 5), Vector(0, 2, 1, 4, 5, 3), Vector(0, 2, 1, 5, 3, 4), ...
// Finca 4
generarProgramacionesRiegoPar(finca4)
//val res4: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5, 6), Vector(0, 1, 2, 3, 4, 6, 5), Vector(0, 1, 2, 3, 5, 4, 6), Vector(0, 1, 2, 3, 5, 6, 4), Vector(0, 1, 2, 3, 6, 4, 5), Vector(0, 1, 2, 3, 6, 5, 4), Vector(0, 1, 2, 4, 3, 5, 6), Vector(0, 1, 2, 4, 3, 6, 5), Vector(0, 1, 2, 4, 5, 3, 6), Vector(0, 1, 2, 4, 5, 6, 3), Vector(0, 1, 2, 4, 6, 3, 5), Vector(0, 1, 2, 4, 6, 5, 3), Vector(0, 1, 2, 5, 3, 4, 6), Vector(0, 1, 2, 5, 3, 6, 4), Vector(0, 1, 2, 5, 4, 3, 6), Vector(0, 1, 2, 5, 4, 6, 3), Vector(0, 1, 2, 5, 6, 3, 4), Vector(0, 1, 2, 5, 6, 4, 3), Vector(0, 1, 2, 6, 3, 4, 5), Vector(0, 1, 2, 6, 3, 5, 4), Vector(0, 1, 2, 6, 4, 3, 5), Vector(0, 1, 2, 6, 4, 5, 3), Vector(0, 1, 2, 6, 5, 3, 4), Vector(0, 1, 2, 6, 5, 4, 3), Vector(0, 1, 3, 2, 4, 5, 6), Vector(0, 1, 3, 2, 4, 6, 5), ...

// Finca 5
generarProgramacionesRiegoPar(finca5)
//val res5: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5, 6, 7), Vector(0, 1, 2, 3, 4, 5, 7, 6), Vector(0, 1, 2, 3, 4, 6, 5, 7), Vector(0, 1, 2, 3, 4, 6, 7, 5), Vector(0, 1, 2, 3, 4, 7, 5, 6), Vector(0, 1, 2, 3, 4, 7, 6, 5), Vector(0, 1, 2, 3, 5, 4, 6, 7), Vector(0, 1, 2, 3, 5, 4, 7, 6), Vector(0, 1, 2, 3, 5, 6, 4, 7), Vector(0, 1, 2, 3, 5, 6, 7, 4), Vector(0, 1, 2, 3, 5, 7, 4, 6), Vector(0, 1, 2, 3, 5, 7, 6, 4), Vector(0, 1, 2, 3, 6, 4, 5, 7), Vector(0, 1, 2, 3, 6, 4, 7, 5), Vector(0, 1, 2, 3, 6, 5, 4, 7), Vector(0, 1, 2, 3, 6, 5, 7, 4), Vector(0, 1, 2, 3, 6, 7, 4, 5), Vector(0, 1, 2, 3, 6, 7, 5, 4), Vector(0, 1, 2, 3, 7, 4, 5, 6), Vector(0, 1, 2, 3, 7, 4, 6, 5), Vector(0, 1, 2, 3, 7, 5, 4, 6), Vector(0, 1, 2, 3, 7, 5, 6, 4), Vector(0, 1, 2, 3, 7, 6, 4, 5), Vector(0, 1, 2, 3,...

//generarProgramacionesRiego
// Finca 0
generarProgramacionesRiego(finca0)
//val res0: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2), Vector(0, 2, 1), Vector(1, 0, 2), Vector(1, 2, 0), Vector(2, 0, 1), Vector(2, 1, 0))

// Finca 1
generarProgramacionesRiego(finca1)
//val res1: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3), Vector(0, 1, 3, 2), Vector(0, 2, 1, 3), Vector(0, 2, 3, 1), Vector(0, 3, 1, 2), Vector(0, 3, 2, 1), Vector(1, 0, 2, 3), Vector(1, 0, 3, 2), Vector(1, 2, 0, 3), Vector(1, 2, 3, 0), Vector(1, 3, 0, 2), Vector(1, 3, 2, 0), Vector(2, 0, 1, 3), Vector(2, 0, 3, 1), Vector(2, 1, 0, 3), Vector(2, 1, 3, 0), Vector(2, 3, 0, 1), Vector(2, 3, 1, 0), Vector(3, 0, 1, 2), Vector(3, 0, 2, 1), Vector(3, 1, 0, 2), Vector(3, 1, 2, 0), Vector(3, 2, 0, 1), Vector(3, 2, 1, 0))

// Finca 2
generarProgramacionesRiego(finca2)
//val res2: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4), Vector(0, 1, 2, 4, 3), Vector(0, 1, 3, 2, 4), Vector(0, 1, 3, 4, 2), Vector(0, 1, 4, 2, 3), Vector(0, 1, 4, 3, 2), Vector(0, 2, 1, 3, 4), Vector(0, 2, 1, 4, 3), Vector(0, 2, 3, 1, 4), Vector(0, 2, 3, 4, 1), Vector(0, 2, 4, 1, 3), Vector(0, 2, 4, 3, 1), Vector(0, 3, 1, 2, 4), Vector(0, 3, 1, 4, 2), Vector(0, 3, 2, 1, 4), Vector(0, 3, 2, 4, 1), Vector(0, 3, 4, 1, 2), Vector(0, 3, 4, 2, 1), Vector(0, 4, 1, 2, 3), Vector(0, 4, 1, 3, 2), Vector(0, 4, 2, 1, 3), Vector(0, 4, 2, 3, 1), Vector(0, 4, 3, 1, 2), Vector(0, 4, 3, 2, 1), Vector(1, 0, 2, 3, 4), Vector(1, 0, 2, 4, 3), Vector(1, 0, 3, 2, 4), Vector(1, 0, 3, 4, 2), Vector(1, 0, 4, 2, 3), Vector(1, 0, 4, 3, 2), Vector(1, 2, 0, 3, 4), Vector(1, 2, 0, 4, 3), Vector(1, 2, 3, 0,...

// Finca 3
generarProgramacionesRiego(finca3)
//val res3: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5), Vector(0, 1, 2, 3, 5, 4), Vector(0, 1, 2, 4, 3, 5), Vector(0, 1, 2, 4, 5, 3), Vector(0, 1, 2, 5, 3, 4), Vector(0, 1, 2, 5, 4, 3), Vector(0, 1, 3, 2, 4, 5), Vector(0, 1, 3, 2, 5, 4), Vector(0, 1, 3, 4, 2, 5), Vector(0, 1, 3, 4, 5, 2), Vector(0, 1, 3, 5, 2, 4), Vector(0, 1, 3, 5, 4, 2), Vector(0, 1, 4, 2, 3, 5), Vector(0, 1, 4, 2, 5, 3), Vector(0, 1, 4, 3, 2, 5), Vector(0, 1, 4, 3, 5, 2), Vector(0, 1, 4, 5, 2, 3), Vector(0, 1, 4, 5, 3, 2), Vector(0, 1, 5, 2, 3, 4), Vector(0, 1, 5, 2, 4, 3), Vector(0, 1, 5, 3, 2, 4), Vector(0, 1, 5, 3, 4, 2), Vector(0, 1, 5, 4, 2, 3), Vector(0, 1, 5, 4, 3, 2), Vector(0, 2, 1, 3, 4, 5), Vector(0, 2, 1, 3, 5, 4), Vector(0, 2, 1, 4, 3, 5), Vector(0, 2, 1, 4, 5, 3), Vector(0, 2, 1, 5, 3, 4), ...

// Finca 4
generarProgramacionesRiego(finca4)
//val res4: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5, 6), Vector(0, 1, 2, 3, 4, 6, 5), Vector(0, 1, 2, 3, 5, 4, 6), Vector(0, 1, 2, 3, 5, 6, 4), Vector(0, 1, 2, 3, 6, 4, 5), Vector(0, 1, 2, 3, 6, 5, 4), Vector(0, 1, 2, 4, 3, 5, 6), Vector(0, 1, 2, 4, 3, 6, 5), Vector(0, 1, 2, 4, 5, 3, 6), Vector(0, 1, 2, 4, 5, 6, 3), Vector(0, 1, 2, 4, 6, 3, 5), Vector(0, 1, 2, 4, 6, 5, 3), Vector(0, 1, 2, 5, 3, 4, 6), Vector(0, 1, 2, 5, 3, 6, 4), Vector(0, 1, 2, 5, 4, 3, 6), Vector(0, 1, 2, 5, 4, 6, 3), Vector(0, 1, 2, 5, 6, 3, 4), Vector(0, 1, 2, 5, 6, 4, 3), Vector(0, 1, 2, 6, 3, 4, 5), Vector(0, 1, 2, 6, 3, 5, 4), Vector(0, 1, 2, 6, 4, 3, 5), Vector(0, 1, 2, 6, 4, 5, 3), Vector(0, 1, 2, 6, 5, 3, 4), Vector(0, 1, 2, 6, 5, 4, 3), Vector(0, 1, 3, 2, 4, 5, 6), Vector(0, 1, 3, 2, 4, 6, 5), ...

// Finca 5
generarProgramacionesRiego(finca5)
//val res5: Vector[finca.ProgRiego] = Vector(Vector(0, 1, 2, 3, 4, 5, 6, 7), Vector(0, 1, 2, 3, 4, 5, 7, 6), Vector(0, 1, 2, 3, 4, 6, 5, 7), Vector(0, 1, 2, 3, 4, 6, 7, 5), Vector(0, 1, 2, 3, 4, 7, 5, 6), Vector(0, 1, 2, 3, 4, 7, 6, 5), Vector(0, 1, 2, 3, 5, 4, 6, 7), Vector(0, 1, 2, 3, 5, 4, 7, 6), Vector(0, 1, 2, 3, 5, 6, 4, 7), Vector(0, 1, 2, 3, 5, 6, 7, 4), Vector(0, 1, 2, 3, 5, 7, 4, 6), Vector(0, 1, 2, 3, 5, 7, 6, 4), Vector(0, 1, 2, 3, 6, 4, 5, 7), Vector(0, 1, 2, 3, 6, 4, 7, 5), Vector(0, 1, 2, 3, 6, 5, 4, 7), Vector(0, 1, 2, 3, 6, 5, 7, 4), Vector(0, 1, 2, 3, 6, 7, 4, 5), Vector(0, 1, 2, 3, 6, 7, 5, 4), Vector(0, 1, 2, 3, 7, 4, 5, 6), Vector(0, 1, 2, 3, 7, 4, 6, 5), Vector(0, 1, 2, 3, 7, 5, 4, 6), Vector(0, 1, 2, 3, 7, 5, 6, 4), Vector(0, 1, 2, 3, 7, 6, 4, 5), Vector(0, 1, 2, 3,...


import org.scalameter.{Key, Warmer, config}

val standardConfig = config(
  Key . exec .minWarmupRuns := 20 ,
  Key . exec .maxWarmupRuns := 40 ,
  Key . exec . benchRuns := 25 ,
  Key . verbose :=false
) withWarmer (Warmer.Default())

// Finca 0
val programacionesRiego0 = standardConfig measure {
  generarProgramacionesRiego(finca0)
}
val programacionesRiegoPar0 = standardConfig measure {
  generarProgramacionesRiegoPar(finca0)
}
val mejoraRendimiento0 = ((programacionesRiego0.value - programacionesRiegoPar0.value) / programacionesRiego0.value) * 100.0
println(s"Mejora de rendimiento para finca 0: $mejoraRendimiento0%")
/*
val programacionesRiego0: org.scalameter.Quantity[Double] = 1.3625960000000004 ms

val programacionesRiegoPar0: org.scalameter.Quantity[Double] = 9.542272 ms


val mejoraRendimiento0: Double = -600.3008962304306
Mejora de rendimiento para finca 0: -600.3008962304306%
* */
// Finca 1
val programacionesRiego1 = standardConfig measure {
  generarProgramacionesRiego(finca1)
}
val programacionesRiegoPar1 = standardConfig measure {
  generarProgramacionesRiegoPar(finca1)
}
val mejoraRendimiento1 = ((programacionesRiego1.value - programacionesRiegoPar1.value) / programacionesRiego1.value) * 100.0
println(s"Mejora de rendimiento para finca 1: $mejoraRendimiento1%")
/*
val programacionesRiego1: org.scalameter.Quantity[Double] = 1.416472 ms


val programacionesRiegoPar1: org.scalameter.Quantity[Double] = 3.3330759999999997 ms


val mejoraRendimiento1: Double = -135.30828706815242
Mejora de rendimiento para finca 1: -135.30828706815242%

*/
// Finca 2
val programacionesRiego2 = standardConfig measure {
  generarProgramacionesRiego(finca2)
}
val programacionesRiegoPar2 = standardConfig measure {
  generarProgramacionesRiegoPar(finca2)
}
val mejoraRendimiento2 = ((programacionesRiego2.value - programacionesRiegoPar2.value) / programacionesRiego2.value) * 100.0
println(s"Mejora de rendimiento para finca 2: $mejoraRendimiento2%")
/*
val programacionesRiego2: org.scalameter.Quantity[Double] = 5.266564000000001 ms


val programacionesRiegoPar2: org.scalameter.Quantity[Double] = 17.579331999999994 ms


val mejoraRendimiento2: Double = -233.79129162771005
Mejora de rendimiento para finca 2: -233.79129162771005%
* */
// Finca 3
val programacionesRiego3 = standardConfig measure {
  generarProgramacionesRiego(finca3)
}
val programacionesRiegoPar3 = standardConfig measure {
  generarProgramacionesRiegoPar(finca3)
}
val mejoraRendimiento3 = ((programacionesRiego3.value - programacionesRiegoPar3.value) / programacionesRiego3.value) * 100.0
println(s"Mejora de rendimiento para finca 3: $mejoraRendimiento3%")
/*
val programacionesRiego3: org.scalameter.Quantity[Double] = 31.011024 ms


val programacionesRiegoPar3: org.scalameter.Quantity[Double] = 12.623839999999996 ms


val mejoraRendimiento3: Double = 59.29241162755543
Mejora de rendimiento para finca 3: 59.29241162755543%
* */
// Finca 4
val programacionesRiego4 = standardConfig measure {
  generarProgramacionesRiego(finca4)
}
val programacionesRiegoPar4 = standardConfig measure {
  generarProgramacionesRiegoPar(finca4)
}
val mejoraRendimiento4 = ((programacionesRiego4.value - programacionesRiegoPar4.value) / programacionesRiego4.value) * 100.0
println(s"Mejora de rendimiento para finca 4: $mejoraRendimiento4%")
/*
val programacionesRiego4: org.scalameter.Quantity[Double] = 71.16136399999999 ms


val programacionesRiegoPar4: org.scalameter.Quantity[Double] = 67.26884 ms


val mejoraRendimiento4: Double = 5.469996331155197
Mejora de rendimiento para finca 4: 5.469996331155197%

* */
// Finca 5
val programacionesRiego5 = standardConfig measure {
  generarProgramacionesRiego(finca5)
}
val programacionesRiegoPar5 = standardConfig measure {
  generarProgramacionesRiegoPar(finca5)
}
val mejoraRendimiento5 = ((programacionesRiego5.value - programacionesRiegoPar5.value) / programacionesRiego5.value) * 100.0
println(s"Mejora de rendimiento para finca 5: $mejoraRendimiento5%")
/*
val programacionesRiego5: org.scalameter.Quantity[Double] = 764.1441960000001 ms


val programacionesRiegoPar5: org.scalameter.Quantity[Double] = 474.4083720000001 ms


val mejoraRendimiento5: Double = 37.91638090253844
Mejora de rendimiento para finca 5: 37.91638090253844%
* */
// Finca 6
val programacionesRiego6 = standardConfig measure {
  generarProgramacionesRiego(finca6)
}
val programacionesRiegoPar6 = standardConfig measure {
  generarProgramacionesRiegoPar(finca6)
}
val mejoraRendimiento6 = ((programacionesRiego6.value - programacionesRiegoPar6.value) / programacionesRiego6.value) * 100.0
println(s"Mejora de rendimiento para finca 6: $mejoraRendimiento6%")
/*
val programacionesRiego6: org.scalameter.Quantity[Double] = 88814.465736 ms


val programacionesRiegoPar6: org.scalameter.Quantity[Double] = 60824.38146799999 ms


val mejoraRendimiento6: Double = 31.51523125883594
Mejora de rendimiento para finca 6: 31.51523125883594%
* */







