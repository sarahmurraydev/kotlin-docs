package udemykotlincourse

fun main() {
    sortCurries(spices)
    sortCurriesByLength(spices)
}

/**
 * Practice Time
 *
 * You can do the following filter exercise in REPL.
 *
 * Create a list of spices, as follows:
 * val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
 * Create a filter that gets all the curries and sorts them by string length.
 *
 * Hint: After you type the dot (.), IntelliJ will give you a list of functions you can apply.
 *
 * Filter the list of spices to return all the spices that start with 'c' and end in 'e'.
 * Do it in two different ways.
 *
 * Take the first three elements of the list and return the ones that start with 'c'.
 *
 * Note: We will be able to do a lot more interesting stuff with filters after you learn about classes and Map.
 */

val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

fun sortCurries(spices: List<String>) {
    val newSpices = spices.filter { it[0] == 'c' }
    printResult(newSpices)
}

fun sortCurriesByLength(spices: List<String>) {
    val newSpices = spices.sortedByDescending { it.length }
    printResult(newSpices)
}

fun printResult(spices: List<String>){
    println("===================================")
    println(spices)
    println("===================================")
}