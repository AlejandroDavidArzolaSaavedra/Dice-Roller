// Función principal
fun main() {
    // Crear una función treatFunction usando trickOrTreat con el parámetro isTrick como falso
    // y extraTreat como una lambda que concatena el número de monedas recibidas.
    val treatFunction = trickOrTreat(false) { "$it quarters" }

    // Crear una función trickFunction usando trickOrTreat con el parámetro isTrick como verdadero
    // y extraTreat como nulo.
    val trickFunction = trickOrTreat(true, null)

    // Llamar a treatFunction cuatro veces
    repeat(4) {
        treatFunction()
    }

    // Llamar a trickFunction
    trickFunction()
}

// Función trickOrTreat que devuelve una lambda (() -> Unit) en función de si es un truco o un trato.
// Si es un truco, devuelve la lambda trick; de lo contrario, imprime el resultado de extraTreat y devuelve la lambda treats.
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    // Si es un truco, devuelve la lambda trick
    if (isTrick) {
        return trick
    } else {
        // Si no es un truco y extraTreat no es nulo, imprime el resultado de extraTreat
        // y devuelve la lambda treats.
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treats
    }
}

// Lambda trick que imprime "No treats!"
val trick = { println("No treats!") }

// Lambda treats que imprime "Have a treat!"
val treats = { println("Have a treat!") }

// Lambda extra que imprime "helllo!!!"
val extra: () -> Unit = { println("helllo!!!")}
