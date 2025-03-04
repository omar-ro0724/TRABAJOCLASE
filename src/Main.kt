fun main() {

    val candidato1 = "Candidato A"
    val candidato2 = "Candidato B"
    val candidato3 = "Candidato C"

    var votosCandidato1 = 0
    var votosCandidato2 = 0
    var votosCandidato3 = 0

    val costoInternet = 700000
    val costoRadio = 200000
    val costoTelevision = 600000

    while (true) {
        println("\n--- Menú de Votación ---")
        println("1. Votar")
        println("2. Calcular costo de campaña")
        println("3. Vaciar urnas")
        println("4. Total de votos")
        println("5. Porcentaje de votos")
        println("6. Costo promedio de campaña")
        println("7. Salir")

        print("Seleccione una opción: ")
        val opcionMenu = readLine()!!.toInt()

        when (opcionMenu) {
            1 -> {
                println("Seleccione su candidato:")
                println("1. Candidato A")
                println("2. Candidato B")
                println("3. Candidato C")

                print("Ingrese el número de su elección: ")
                val opcionVoto = readLine()!!.toInt()

                when (opcionVoto) {
                    1 -> votosCandidato1++
                    2 -> votosCandidato2++
                    3 -> votosCandidato3++
                    else -> println("Opción no válida.")
                }
            }
            2 -> {
                val costoCampana1 = votosCandidato1 * (costoInternet + costoRadio + costoTelevision)
                val costoCampana2 = votosCandidato2 * (costoInternet + costoRadio + costoTelevision)
                val costoCampana3 = votosCandidato3 * (costoInternet + costoRadio + costoTelevision)

                println("Costo de campaña Candidato A: $$costoCampana1")
                println("Costo de campaña Candidato B: $$costoCampana2")
                println("Costo de campaña Candidato C: $$costoCampana3")
            }
            3 -> {
                votosCandidato1 = 0
                votosCandidato2 = 0
                votosCandidato3 = 0
                println("Las urnas han sido vaciadas.")
            }
            4 -> {
                val totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3
                println("Total de votos: $totalVotos")
            }
            5 -> {
                val totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3
                if (totalVotos > 0) {
                    val porcentaje1 = (votosCandidato1.toDouble() / totalVotos) * 100
                    val porcentaje2 = (votosCandidato2.toDouble() / totalVotos) * 100
                    val porcentaje3 = (votosCandidato3.toDouble() / totalVotos) * 100

                    println("Porcentaje de votos Candidato A: ${"%.2f".format(porcentaje1)}%")
                    println("Porcentaje de votos Candidato B: ${"%.2f".format(porcentaje2)}%")
                    println("Porcentaje de votos Candidato C: ${"%.2f".format(porcentaje3)}%")
                } else {
                    println("No hay votos registrados.")
                }
            }
            6 -> {
                val costoCampana1 = votosCandidato1 * (costoInternet + costoRadio + costoTelevision)
                val costoCampana2 = votosCandidato2 * (costoInternet + costoRadio + costoTelevision)
                val costoCampana3 = votosCandidato3 * (costoInternet + costoRadio + costoTelevision)

                val totalCosto = costoCampana1 + costoCampana2 + costoCampana3
                val totalVotos = votosCandidato1 + votosCandidato2 + votosCandidato3

                if (totalVotos > 0) {
                    val costoPromedio = totalCosto / totalVotos
                    println("Costo promedio de campaña: $$costoPromedio")
                } else {
                    println("No hay votos registrados para calcular el costo promedio.")
                }
            }
            7 -> {
                println("Saliendo del programa.")
                return
            }
            else -> {
                println("Opción no válida.")
            }
        }
    }
}