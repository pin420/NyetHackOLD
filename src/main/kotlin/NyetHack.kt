




val player = Player()

fun main() {

//    changeNarratorMood()

    narrate("${player.name}, ${createTitle(player.name)}, heads to the town square")

    visitTavern()

    player.castFireball()
}


private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?"
    ) { message -> "\u001b[33;1m$message\u001b[0m" }

//    val input = readLine()
//    require(!heroName.isNullOrEmpty()) {
//        "The hero must have a name"
//    }
//    return input

    println("Madrigal")
    return "Madrigal"
}


private fun createTitle(name: String): String {
    return when {
        name.all { letter -> letter.isDigit() } -> "The Identifiable"
        name.none { letter -> letter.isLetter() } -> "The Witness Protection Member"
        name.count { letter -> letter.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
        else -> "The Renowned Hero"
    }
}
