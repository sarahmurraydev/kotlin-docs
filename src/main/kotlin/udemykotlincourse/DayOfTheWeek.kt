import java.util.Calendar

fun dayOfTheWeek(): String {
    val intOfDay = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    return mapIntToDay(intOfDay)
}

fun mapIntToDay(dayAsInt: Int) : String {
    return when (dayAsInt) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        // otherwise there was an error or there is a new day of the week:
        else -> "Error - is this a parallel universe?"
    }
}

fun main(args: Array<String>) {
    println("Hello World")
    println("Today is ${dayOfTheWeek()}")
}