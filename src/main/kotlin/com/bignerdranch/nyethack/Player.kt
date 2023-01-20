package com.bignerdranch.nyethack

class Player(
    initialName: String,
    val hometown: String = "Neversummer",
    override var healthPoints: Int,
    val isImmortal: Boolean
) : Fightable {

    override var name = initialName
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

    val prophecy by lazy {
        narrate("$name embarks on an arduous quest to locate a fortune teller")
        Thread.sleep(3000)
        narrate("The fortune teller bestows a prophecy upon $name")
        "An intrepid hero from $hometown shall some day " + listOf(
            "form an unlikely bond between two warring factions",
            "take possession of an otherworld blade",
            "bring the gift of creation back to the world",
            "best the world-eater"
        ).random()
    }

    override val diceCount = 3

    override val diceSides = 4

    init {
        require(healthPoints > 0 ) {"healthPoints must be greater than zero"}
        require(name.isNotBlank()) {"Player must have a name"}
    }

    constructor(name: String) : this(
        initialName = name,
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

    fun prophesize() {
        narrate("$name thinks about their future")
        narrate("A fortune teller told Madrigal, \"$prophecy\"")
    }

    override fun takeDamage(damage: Int) {
        if (!isImmortal) {
            healthPoints -= damage
        }
    }

    override fun attack(opponent: Fightable) {
        TODO("Not yet implemented")
    }
}
