
fun main() {
    val birthday = getBirthday()
    println("Your fortune is: ${getFortuneCookie(birthday)}")
}

val fortunes = mutableListOf(
    "You will have a great day!",
    "Things will go well for you today.",
    "Enjoy a wonderful day of success.",
    "Be humble and all will turn out well.",
    "Today is a good day for exercising restraint.",
    "Take it easy and enjoy life!",
    "Treasure your friends because they are your greatest fortune."
)

fun filterFortunes(){
    fortunes.filter { it[it.length-1] == '!'}
}

fun getFortuneCookie(birthday: Int?) : String {
    var fortuneIndex = 1
    birthday?.let {
        fortuneIndex = birthday % fortunes.size
    }
    return fortunes[fortuneIndex]
}

fun getBirthday() : Int? {
    // when entering this value in the terminal, be sure to go to the next line:
    // "enter your birth day" |
    // *click enter to go a new line* 4
    // *click enter again for the program to continue running and your value to be read
    print("enter your birth day:")
    return readLine()?.toIntOrNull()
}
