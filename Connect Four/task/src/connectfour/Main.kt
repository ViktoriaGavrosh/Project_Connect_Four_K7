package connectfour

fun main() {
    val gameWinner = Game(startGame()).determineWinner()
}

fun startGame(): MutableList<Player> {   // поменять на лист
    println("Connect Four")
    println("First player's name:")
    val players = mutableListOf(Player(readln(), "o"))
    println("Second player's name:")
    players.add(Player(readln(), "*"))
    return players
}
