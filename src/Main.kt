fun main() {
    val alcancia = Alcancia()
    var continuar = true

    while (continuar) {
        println("""MENU DE OPCIONES""")
        println("1. Agregar moneda")
        println("2. Contar monedas por denominación")
        println("3. Calcular total ahorrado")
        println("4. Romper alcancía")
        println("5. Salir")

        print("Selecciona una opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> alcancia.agregarMoneda()
            2 -> alcancia.contarMonedas()
            3 -> alcancia.calcularTotal()
            4 -> alcancia.romperAlcancia()
            5 -> {
                println("¡Gracias por usar tu Alcancía Digital!")
                continuar = false
            }
            else -> println("Opción inválida. Intenta de nuevo.")
        }
    }
}

class Alcancia {
    private val monedas = mutableMapOf(20 to 0, 50 to 0, 100 to 0, 200 to 0, 500 to 0)

    fun agregarMoneda() {
        println("Selecciona la denominación:")
        println("1. $20  2. $50  3. $100  4. $200  5. $500")
        print("Ingresa tu elección: ")

        when (readLine()?.toIntOrNull()) {
            1 -> agregar(20)
            2 -> agregar(50)
            3 -> agregar(100)
            4 -> agregar(200)
            5 -> agregar(500)
            else -> println("Opción inválida")
        }
    }

    private fun agregar(denominacion: Int) {
        monedas[denominacion] = monedas[denominacion]!! + 1
        println("Se agregó una moneda de $$denominacion")
    }

    fun contarMonedas() {
        if (monedas.values.sum() == 0) {
            println("La alcancía está vacía")
            return
        }
        println("Monedas por denominación:")
        monedas.forEach { (denominacion, cantidad) -> println("$$denominacion: $cantidad moneda(s)") }
    }

    fun calcularTotal() {
        val total = monedas.entries.sumOf { it.key * it.value }
        println("Total en la alcancía: $$total")
    }

    fun romperAlcancia() {
        if (monedas.values.sum() == 0) {
            println("La alcancía está vacía, no hay nada que romper")
            return
        }
        println("Al romper la alcancía encontraste:")
        monedas.forEach { (denominacion, cantidad) -> println("$$denominacion: $cantidad moneda(s)") }
        println("Total recuperado: $${monedas.entries.sumOf { it.key * it.value }}")
        monedas.keys.forEach { monedas[it] = 0 }
        println("La alcancía ha sido vaciada.")
    }
}