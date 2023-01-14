package com.bignerdranch.nyethack






import kotlin.random.Random
import kotlin.random.nextInt

var narrationModifier: (String) -> String = { message -> message }

inline fun narrate(
    message: String,
    modifier: (String) -> String = { str -> narrationModifier(str) }
) {
    println(modifier(message))
}

fun changeNarratorMood() {
    val mood: String
    val modifier: (String) -> String
    when (Random.nextInt(1..5)) {
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
        4 -> {
            var narrationGiven = 0
            mood = "like sending an itemized bill"
            modifier = { message ->
                narrationGiven++
                "$message.\n(I have narrated $narrationGiven things)"
            }
        }
        else -> {
            mood = "professional"
            modifier = { message -> "$message." }
        }
    }
    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}