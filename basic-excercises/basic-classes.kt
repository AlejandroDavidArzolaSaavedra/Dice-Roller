// Manejandonos con las clases en Android
class SmartDevice(
    var name: String = "Android TV",
    var category: String = "Entertainment",
    var deviceStatus: String = "online"
) {
    init {
        updateDeviceStatus()
    }

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }

    private fun updateDeviceStatus(statusCode: Int = 1) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
}

var speakerVolume: Int = 2
    get() = field
    set(value) {
        field = value
    }

var speakerVolumeWithRange: Int = 2
    set(value) {
        if (value in 0..100) {
            field = value
        }
    }

fun main() {
    val smartTvDevice = SmartDevice(name = "Smart TV", category = "Entertainment", deviceStatus = "online")

    // Mostrar información del dispositivo
    println("Device details: $smartTvDevice")
    println("Device name is: ${smartTvDevice.name}")

    // Operaciones en el dispositivo
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()

    // Cambiar el volumen del altavoz
    speakerVolume = 5
    println("Speaker volume: $speakerVolume")

    // Cambiar el volumen del altavoz con rango
    speakerVolumeWithRange = 75
    println("Speaker volume with range: $speakerVolumeWithRange")
}
