


class Player {

    var name = "madrigal"
        get() = field.replaceFirstChar { char -> char.uppercase() }
        set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) {
        narrate("A glass of Fireballs springs into existence (x$numFireballs)")
    }

}