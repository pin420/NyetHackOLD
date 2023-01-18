package com.bignerdranch.nyethack

//val player = Player("Jason")

lateinit var player: Player

fun main() {

    narrate("Welcome to NeatHack!")
    val playerName = promptHeroName()
    player = Player(playerName)

//    com.bignerdranch.nyethack.changeNarratorMood()



    Game.play()
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


object Game {
    private val currentRoom: Room = TownSquare()

    init {
        narrate("Welcome, adventurer")
        val mortality = if (player.isImmortal) "an immortal" else "a mortal"
        narrate("${player.name}, $mortality, has ${player.healthPoints} health points")
    }

    fun play() {
        while (true) {
            narrate("${player.name} of ${player.hometown}, ${player.title}," +
                    " is in ${currentRoom.description()}")
            currentRoom.enterRoom()

            print("> Enter your command: ")
            GameInput(readLine()).processCommand()
        }
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when (command.lowercase()) {
            else -> narrate("I'm not sure what you're trying to do")
        }
    }
}

