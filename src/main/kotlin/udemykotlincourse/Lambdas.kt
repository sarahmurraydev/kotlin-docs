package udemykotlincourse

import java.lang.Math.random
import java.util.Random

fun main(){
    val roll = rollDiceWithSides(0)
    println("You rolled a $roll")
}

/**
 * Practice Time: Lambdas
 *
 * Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
 **/

val rollDice = { Random().nextInt(12) + 1 }

/**
 * Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
 **/
val rollDiceWithSides: (Int) -> Int = { sides ->
    when (sides) {
        0 -> 0
        else -> Random().nextInt(sides) + 1
    }
}

/**
 * If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
 * Create a new variable, rollDice2, for this same lambda using the function type notation.
 * **/
// handled above