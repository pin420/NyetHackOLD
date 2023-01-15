package com.bignerdranch.nyethack


class Player(
    initialName: String,
    val hometown: String,
    var healthPoints: Int,
    val isImmortal: Boolean
) {

    var name = initialName
        get() = field.replaceFirstChar { char -> char.uppercase() }
        private set(value) {
            field = value.trim()
        }

    val title: String
        get() = when {
            name.all { letter -> letter.isDigit() } -> "The Identifiable"
            name.none { letter -> letter.isLetter() } -> "The Witness Protection Member"
            name.count { letter -> letter.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
            else -> "The Renowned Hero"
        }

    constructor(name: String, hometown: String) : this(
        initialName = name,
        hometown = hometown,
        healthPoints = 100,
        isImmortal = false
    ) {
        if (name.equals("Jason", ignoreCase = true)) {
            healthPoints = 500
        }
    }

    fun castFireball(numFireballs: Int = 2) {
        narrate("A glass of Fireballs springs into existence (x$numFireballs)")
    }

    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }
}