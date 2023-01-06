








val narrationModifier: (String) -> String = { message ->
    val numExclamationPoints = 3
    message.uppercase() +"!".repeat(numExclamationPoints)
}

fun narrate(
    message: String
) {
    println(narrationModifier(message))
}