


fun narrate( message: String) {

    val narrationModifier: () -> String = {
        val numExclamationPoints = 3
        message.uppercase() +"!".repeat(numExclamationPoints)
    }

    println(narrationModifier())
}