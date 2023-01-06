






import kotlin.random.Random
import kotlin.random.nextInt

var narrationModifier: (String) -> String = { message -> message }

fun narrate(
    message: String,
    modifier: (String) -> String = { str -> narrationModifier(str) }
) {
    println(modifier(message))
}

fun changeNarratorMood() {
    val mood: String
    val modifier: (String) -> String
    when (Random.nextInt(1..4)) {
        1 -> {
            mood = "loud"
            modifier = { message ->
                val numExclamationPoint = 3
                message.uppercase() + "!".repeat(numExclamationPoint)
            }
        }
        2 -> {
            mood = "tired"
            modifier = { message ->
                message.lowercase().replace(" ", "... ")
            }
        }
        3 -> {
            mood = "unsure"
            modifier = { message -> "$message?" }
        }
        else -> {
            mood = "professional"
            modifier = { message -> "$message." }
        }
    }
    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}