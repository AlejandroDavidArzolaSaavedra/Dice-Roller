fun main() {

    val winningBid = Bid(5000, "Private Collector")

    println("Item A es vendido a  ${auctionPrice(winningBid, 2000)}.")
    println("Item B es vendido a  ${auctionPrice(null, 3000)}.")
    
     val foldablePhone = FoldablePhone()

    foldablePhone.checkPhoneScreenLight() // Output: The phone screen's light is off.

    foldablePhone.unfold()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight() // Output: The phone screen's light is on.

    foldablePhone.fold()
    foldablePhone.switchOn() // Output: Cannot switch on the screen when the phone is folded.
    
    val andrea = Person("Andrea", 33, "play tennis", null)
    val silvia = Person("Silvia", 28, "climb", andrea)

    andrea.showProfile()
    silvia.showProfile()
    
    val mySong = Song("Disturbia", "Rihanna", 2022, 800)

    // Imprimir descripción
    mySong.printSongDescription()

    // Verificar si la canción es popular
    if (mySong.isPopular) {
        println("Esta canción es popular.")
    } else {
        println("Esta canción no es muy popular.")
    }
    
    // Notificaciones del día
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)

    // Precios de entradas de cine
    val child = 5
    val adult = 28
    val senior = 87
    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")

    // Conversor de temperatura
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { celsiusToFarhrenheit(it) }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { kelvinToCelsius(it) }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { fahrenheitToKelvin(it) }
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return if (bid != null && bid.amount > minimumPrice) {
        bid.amount
    } else {
        minimumPrice
    }
}

class FoldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean = true) : Phone(isScreenLightOn) {

    // Método para desplegar el teléfono
    fun unfold() {
        isFolded = false
    }

    // Método para plegar el teléfono
    fun fold() {
        isFolded = true
        // Apaga la pantalla cuando se pliega el teléfono
        switchOff()
    }

    // Sobrescribe el comportamiento de switchOn para tener en cuenta el estado plegado/desplegado
    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        } else {
            println("Cannot switch on the screen when the phone is folded.")
        }
    }
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        // Mostrar el hobby si está presente
        hobby?.let {
            println("Hobby: $it")
        }

        // Mostrar el referrador si está presente
        referrer?.let {
            println("Referred by: ${it.name}")
        }

        println()    }
}

class Song(
    val title: String,
    val artist: String,
    val yearReleased: Int,
    var playCount: Int
) {
    // Propiedad que indica si la canción es popular
    val isPopular: Boolean
        get() = playCount >= 1000

    // Método para imprimir la descripción de la canción
    fun printSongDescription() {
        println("$title, interpretada por $artist, se lanzó en $yearReleased.")
    }
}


// Función para imprimir un resumen de notificaciones del teléfono
fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have $numberOfMessages notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

// Función para calcular el precio de la entrada de cine según la edad
fun ticketPrice(age: Int, isMonday: Boolean): Int {
    return when(age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}

// Función para imprimir la temperatura final después de la conversión
fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // dos decimales
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

// Funciones de conversión de temperatura
fun celsiusToFarhrenheit(celsius: Double): Double = celsius * 9 / 5 + 32

fun kelvinToCelsius(kelvin: Double): Double = kelvin - 273.15

fun fahrenheitToKelvin(fahrenheit: Double): Double = (fahrenheit + 459.67) * 5 / 9
