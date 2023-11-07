fun main() {
    // Operador null y operador Elvis
    
    // Ejemplos de asignación de valores y nulos
    val favoriteActor: String = "Sandra Oh"
    val nullableActor: String? = null
    
    println(nullableActor)
    
    // Variante de variable mutable
    var currentFavoriteActor: String = "Sandra Oh"
    currentFavoriteActor = "Meryl Streep"
    
    println(currentFavoriteActor)
    
    // Uso del tipo de dato nullable
    var selectedActor: String? = "Sandra Oh"
    selectedActor = null
    
    println(selectedActor)
    
    // Uso de tipo de dato nullable con Int
    var number: Int? = 10
    println(number)

    number = null
    println(number)
    
    // Acceso seguro a propiedades en tipos de datos nullable
    var favoriteActorLength: Int = favoriteActor.length
    println(favoriteActorLength)
    
    var nullableActorLength: Int? = selectedActor?.length
    println(nullableActorLength)
    
    var nullActor: String? = null
    println(nullActor?.length)
    
    // Uso del operador `?.` para acceder a propiedades y operador Elvis
    var anotherActor: String? = "Sandra Oh"

    val lengthOfName = anotherActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName.")
    
    // Uso del operador Elvis en una expresión if
    val followingActor: String? = "Sandra Oh"

    val lengthOfNameIfNotNull = followingActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfNameIfNotNull.")
    
    // Uso del operador Elvis para asignar un valor predeterminado si el valor es nulo
    val restActor: String? = "Sandra Oh"

    val lengthName = restActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthName.")
}
