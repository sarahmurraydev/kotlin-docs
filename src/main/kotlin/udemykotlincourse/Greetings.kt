import java.util.Calendar

fun main() {
    println(
        "Good ${ if (Calendar.getInstance().get(Calendar.AM_PM) == 1) "night" else "morning" }, Kotlin"
    )
}