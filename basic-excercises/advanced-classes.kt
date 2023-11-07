import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Clase base para todos los dispositivos inteligentes
open class SmartDevice(val name: String, val category: String) {

    // Estado del dispositivo, con un setter protegido
    var deviceStatus = "online"
        protected set

    // Tipo de dispositivo, puede ser sobrescrito en subclases
    open val deviceType = "unknown"

    // Método para encender el dispositivo
    open fun turnOn() {
        deviceStatus = "on"
    }

    // Método para apagar el dispositivo
    open fun turnOff() {
        deviceStatus = "off"
    }
}

// Subclase para un dispositivo de TV inteligente
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    // Sobrescribe el tipo de dispositivo
    override val deviceType = "Smart TV"

    // Propiedades reguladas para el volumen del altavoz y el número del canal
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Sobrescribe el método para encender el dispositivo
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    // Sobrescribe el método para apagar el dispositivo
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

    // Métodos específicos para aumentar el volumen y cambiar de canal
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}

// Subclase para un dispositivo de luz inteligente
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    // Sobrescribe el tipo de dispositivo
    override val deviceType = "Smart Light"
    
     // Propiedad regulada para el nivel de brillo
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Sobrescribe el método para encender el dispositivo
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is $brightnessLevel.")
    }

    // Sobrescribe el método para apagar el dispositivo
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off")
    }

    // Método específico para aumentar el brillo
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
}

// Clase para representar un hogar inteligente con dispositivos específicos
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    // Contador privado para el número total de dispositivos encendidos
    var deviceTurnOnCount = 0
        private set

    // Método para encender el televisor
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    // Método para apagar el televisor
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    // Método para aumentar el volumen del televisor
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    // Método para cambiar el canal del televisor
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    // Método para encender la luz
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    // Método para apagar la luz
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    // Método para aumentar el brillo de la luz
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    // Método para apagar todos los dispositivos
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Clase para regular un valor en un rango específico
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    // Datos de campo para almacenar el valor actual
    private var fieldData = initialValue

    // Método para obtener el valor actual
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // Método para establecer un nuevo valor, validando que esté en el rango permitido
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Función principal
fun main() {
    // Crear una instancia de SmartHome con dispositivos específicos
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    // Interactuar con los dispositivos en el hogar inteligente
    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
}
