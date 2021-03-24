package google.code.labs

fun main() {
    val myFirstDice = DiceRoller(6)
    myFirstDice.printSides()
    println("I rolled a ${myFirstDice.roll()}")

    val mySecondDice = DiceRoller(20, color = "Red")
    mySecondDice.printSides()
    println("I rolled a ${mySecondDice.roll()}")

    val myCoin = Coin()
    println("I flipped a ${myCoin.flip()}")
}

class DiceRoller(
    val sides: Int,
    var color: String = "Black"
) {

    fun roll(): Int{
        return (1..sides).random()
    }

    fun printSides() {
        println("My die has: ${this.sides} sides")
    }
}

class Coin() {
    val sides = listOf<String>("heads", "tails")

    fun flip(): String {
        return sides.random()
    }
}