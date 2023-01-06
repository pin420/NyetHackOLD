


fun main() {
    narrate("A hero enters the town of Kronstadt. What is their name?",
    { message ->
        "\u001b[33;1m$message\u001b[0m"

    }
    )
    val heroName = readLine() ?: ""

    changeNarratorMood()
    narrate("$heroName heads to the town square")
}
