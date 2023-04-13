package connectfour

fun main() {
    val game1 = Game(startGame())
}

fun startGame(): MutableList<Player> {
    println("Connect Four")
    println("First player's name:")
    val players = mutableListOf(Player(readln(), "W"))
    println("Second player's name:")
    players.add(Player(readln(), "B"))
    return players
}
