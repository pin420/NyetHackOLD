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

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    narrate(menuItem.joinToString())

    val patrons: MutableSet<String> = mutableSetOf()
    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.0,
        heroName to 4.50
    )

    while(patrons.size < 5) {
        val patronName = "${firstNames.random()} ${lastNames.random()}"
        patrons += patronName
        patronGold += patronName to 6.00
    }

    narrate("$heroName sees several patrons in tavern:")
    narrate(patrons.joinToString())

    println(patronGold)
    repeat(3) {
        placeOrder(patrons.random(), menuItem.random(), patronGold)
    }
    println(patronGold)
}


private fun placeOrder(
    patronName: String,
    menuItemName: String,
    patronGold: MutableMap<String, Double>
) {
    val itemPrice = 1.0

    narrate("$patronName speaks with $TAVERN_MASTER to place an order")

    if (itemPrice <= patronGold.getOrDefault(patronName, 0.0)) {
        narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
        narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
        patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
        patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
    } else {
        narrate("$TAVERN_MASTER says, \" You need more coin for a $menuItemName\"")
    }
}