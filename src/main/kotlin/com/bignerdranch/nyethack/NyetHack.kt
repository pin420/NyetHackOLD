package com.bignerdranch.nyethack




//val player = Player("Jason")

lateinit var player: Player

fun main() {

    narrate("Welcome to NeatHack!")
    val playerName = promptHeroName()
    player = Player(playerName)

//    com.bignerdranch.nyethack.changeNarratorMood()
    player.prophesize()

    val currentRoom: Room = TownSquare()
    val mortality = if (player.isImmortal) "an immortal" else "a mortal"

    narrate("${player.name} of ${player.hometown}, ${player.title}," +
            " is in ${currentRoom.description()}")

    narrate("${player.name}, $mortality, has ${player.healthPoints} health points")

    currentRoom.enterRoom()

    player.castFireball()
    player.prophesize()
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

