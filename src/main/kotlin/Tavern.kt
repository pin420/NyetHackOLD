import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"
private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")


fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")

    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")

    patrons.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line")
        placeOrder(patron, "Dragon's Breath")
    }

    menuData.forEachIndexed { index, data ->
        println("$index : $data")
    }
}


private fun placeOrder(patronName: String, menuItemName: String) {
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}