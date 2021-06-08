package google.code.labs

import kotlin.math.PI

private fun main(){
    val myCabin = SquareCabin(8, 30.0)
    // you can print properties of your cabin like so:
    println("\n My Square Cabin\n===============")
    println("Capacity: ${myCabin.capacity}")
    println("Material: ${myCabin.buildingMaterial}")
    println("Has room? ${myCabin.hasRoom()}")

    // although the above print lns are redundant and there is a short cut you can use!
    // use the `with` method to apply a set of functions to an object like so:
    with(myCabin) {
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
        println("\n My Square Cabin\n===============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Area of floor: ${floorArea()}")
        println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
    }

    val myHut = RoundHut(2, 8.0)
    with(myHut) {
        println(" My Round Hut")
        println("@@@@@@@@@@@@@@")
        println("@@@@@@@@@@@@@@")
        println("@@@@@@@@@@@@@@")
        println("@@@@@    @@@@@")
        println("@@@@@    @@@@@")
        println("--------------")
        println("Area: ${floorArea()}")
        println("Has Room: ${hasRoom()}")
    }
}

abstract class Dwelling(private var residents: Int){
    // in this class, define things that are true for all dwellings, even if the values are different for all dwellings
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    // abstract classes can also have abstract functions that will be fully defined in the class
    abstract fun floorArea(): Double
    // the area needs to be abstract bc the formula depends on the type of cabin it is.
    // abstract fun do not need `{}` because they aren't defining what to do
}

class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "wood"
    override val capacity = 10
    override fun floorArea(): Double {
        return length * length
    }
}

class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "straw"
    override val capacity = 3
    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

open class Apartment(residents: Int, val length: Double, val width: Double): Dwelling(residents){
    override val buildingMaterial = "concrete"
    override val capacity = 2
    override fun floorArea(): Double {
        return length * width
    }
}

class ApartmentComplex(
    residents: Int,
    length: Double,
    width: Double,
    floors: Int = 2,
    unitsPerFloor: Int = 10
): Apartment(residents, length, width) {
    private val numberOfApts = floors * unitsPerFloor
    // apartment complex capacity it the capcity of an apartment
    // times the total number of apartments
    override val capacity = super.capacity * numberOfApts
    override fun floorArea(): Double {
        // for the purpose of this exercise we will assume there are no
        // hallways or common spaces so the area of the apt complex is the
        // sum of the area of all apartments (or #apts * area of one apt)
        val apartmentArea = super.floorArea()
        return apartmentArea * numberOfApts
    }
}

/**
 * Notes on Abstract Classes
 *
 * Abstract classes are a "sketch" for a class.
 * A class itself is the blueprint for an instance of that class
 *
 * Abstract classes allow you to say "hey the implementation of this class
 * **must** have these properties of functions (bc AS will error if you
 * haven't implement or defined an abstract class' method or values respectively)
 *
 * Dwelling is an abstract class
 * SquareCabin, RoundHut, and Apartment are subclasses (not abstract)
 * myCabin and myHut are instances of these subclasses
 *
 * Apartment is an open subclass of Dwelling, meaning it can have it's own subclasses (ApartmentComplex)
 * */

