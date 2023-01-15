package com.bignerdranch.nyethack




val player = Player("Jason")

fun main() {

//    com.bignerdranch.nyethack.changeNarratorMood()

    val mortality = if (player.isImmortal) "an immortal" else "a mortal"

    narrate("${player.name} of ${player.hometown}, ${player.title}, heads to the town square")

    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")

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

