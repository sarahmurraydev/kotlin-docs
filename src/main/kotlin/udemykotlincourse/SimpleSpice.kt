package udemykotlincourse

class SimpleSpice(val name: String, val spiciness: String) {
    val heat: Int
        get() = 5
}

val sampleSpice = SimpleSpice("old bar", "low")

fun main(){
    println("We are looking at spice: ${sampleSpice.name}")
    println("${sampleSpice.name} has a spiciness of ${sampleSpice.spiciness} which coorelates to a heat of ${sampleSpice.heat}")
}