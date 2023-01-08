import java.io.File

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"
private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
private val menuItem = List(menuData.size) { index ->
    val (_, name, _) = menuData[index].split(",")
    name
}


fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    println(menuItem)

    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")

    patrons.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line")
        placeOrder(patron, menuItem.random())
    }
}


private fun placeOrder(patronName: String, menuItemName: String) {
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}