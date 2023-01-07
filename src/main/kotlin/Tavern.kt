






private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"



fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")

    val patrons: List<String> = listOf("Eli", "Mordoc", "Sophie")
    println(patrons)
}