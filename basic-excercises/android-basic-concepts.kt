fun main() {
    // Ejemplo de comprobaciones booleanas
    // val number = 1
    // println(number == number)
    // println(number < number)

    // Ejemplo de manejo de luces de tráfico
    val trafficLightColor = "Red"

    // Usando WHEN para simplificar el manejo de múltiples condiciones
    val action = when (trafficLightColor) {
        "Red" -> "Stop"
        "Yellow" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(action)

    // Ejemplo con números primos y rango
    val x = 3
    val primeMessage = when (x) {
        in 2..7 -> "$x is a prime number between 1 and 10"
        else -> "$x is not a prime number between 1 and 10"
    }
    println(primeMessage)

    // Ejemplo con tipos de datos mixtos
    val z: Any = 5
    val mixedTypeMessage = when (z) {
        in 2..7 -> "$z is a prime number between 1 and 10."
        in 1..10 -> "$z is a number between 1 and 10, but not a prime number."
        is Int -> "$z is an integer number, but not between 1 and 10."
        else -> "$z isn't a prime number between 1 and 10."
    }
    println(mixedTypeMessage)

    // Ejemplo con múltiples opciones para un caso
    val trafficColor = "Amber"
    val actionForTrafficColor = when (trafficColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(actionForTrafficColor)

    // Ejemplo con asignación de resultado a una variable
    val trafficColorLight = "Amber"
    val message = when (trafficColorLight) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
}