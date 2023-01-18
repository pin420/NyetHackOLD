package com.bignerdranch.nyethack

import java.io.File
import kotlin.random.Random
import kotlin.random.nextInt

private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"
private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
    .map { line -> line.split(",") }

private val menuItems = menuData.map { (_, name, _) -> name }

private val menuItemPrices: Map<String, Double> = menuData.associate { (_, name, price) -> name to price.toDouble() }

private val menuItemType: Map<String, String> = menuData.associate { (type, name, _) -> name to type }

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernsworth", "Baggins", "Downstrider")


class Tavern : Room(TAVERN_NAME) {
    val patrons: MutableSet<String> = firstNames.shuffled()
        .zip(lastNames.shuffled()) { firstNames, lastNames -> "$firstNames $lastNames"}
        .toMutableSet()

    val patronGold = mutableMapOf(
        TAVERN_MASTER to 86.0,
        player.name to 4.50,
        *patrons.map { patron -> patron to 6.0 }.toTypedArray()
    )

    val itemOfDay = patrons.flatMap { patron -> getFavoriteMenuItems(patron) }.random()

    override val status = "Busy"
    override fun enterRoom() {
        narrate("${player.name} enters $TAVERN_NAME")
        narrate("There are several items for sale:")
        narrate(menuItems.joinToString())
        narrate("The item of the day is the $itemOfDay")
        narrate("${player.name} sees several patrons in tavern:")
        narrate(patrons.joinToString())

        placeOrder(patrons.random(), menuItems.random())
    }

    private fun placeOrder(
        patronName: String,
        menuItemName: String
    ) {
        val itemPrice = menuItemPrices.getValue(menuItemName)

        narrate("$patronName speaks with $TAVERN_MASTER to place an order")

        if (itemPrice <= patronGold.getOrDefault(patronName, 0.0)) {
            val action = when (menuItemType[menuItemName]) {
                "shandy", "elixir" -> "pours"
                "meal" -> "serves"
                else -> "hands"
            }
            narrate("$TAVERN_MASTER $action $patronName a $menuItemName")
            narrate("$patronName pays $TAVERN_MASTER $itemPrice gold")
            patronGold[patronName] = patronGold.getValue(patronName) - itemPrice
            patronGold[TAVERN_MASTER] = patronGold.getValue(TAVERN_MASTER) + itemPrice
        } else {
            narrate("$TAVERN_MASTER says, \" You need more coin for a $menuItemName\"")
        }
    }
}


private fun getFavoriteMenuItems(patron: String): List<String> {
    return when (patron) {
        "Alex Ironfoot" -> menuItems.filter { menuItem ->
            menuItemType[menuItem]?.contains("dessert") == true
        }
        else -> menuItems.shuffled().take(Random.nextInt(1..2))
    }
}