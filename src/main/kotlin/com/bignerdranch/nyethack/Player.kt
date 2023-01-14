package com.bignerdranch.nyethack


class Player {

    var name = "madrigal"
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

    fun castFireball(numFireballs: Int = 2) {
        narrate("A glass of Fireballs springs into existence (x$numFireballs)")
    }

    fun changeName(newName: String) {
        narrate("$name legally changes their name to $newName")
        name = newName
    }
}