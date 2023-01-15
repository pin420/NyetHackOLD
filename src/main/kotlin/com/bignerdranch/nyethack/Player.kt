package com.bignerdranch.nyethack


class Player(
    initialName: String,
    hometown: String,
    healthPoints: Int,
    isImmortal: Boolean
) {

    var name = initialName
        get() = field.replaceFirstChar { char -> char.uppercase() }
        private set(value) {
            field = value.trim()
        }

    val hometown = hometown

    var healthPoints = healthPoints

    val isImmortal = isImmortal

    val title: String
        get() = when {
            name.all { letter -> letter.isDigit() } -> "The Identifiable"
            name.none { letter -> letter.isLetter() } -> "The Witness Protection Member"
            name.count { letter -> letter.lowercase() in "aeiou" } > 4 -> "The Master of Vowel"
            else -> "The Renowned Hero"
        }

    fun castFireball(numFireballs: Int = 2) {
        narrate("A glass of Fireballs springs into existence (x$numFireballs)")
    }

    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }
}