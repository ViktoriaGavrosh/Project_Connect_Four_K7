package connectfour

fun main() {
    val players = initPlayers()
    val gameboard = GameBoard(players)
    var gameNumber = howManyGames()
    startGame(gameboard, gameNumber)
    repeat(gameNumber) {
        Game(players, gameNumber, gameboard.board).play()
    }
}

private fun startGame(gameboard: GameBoard, gameNumber: Int) {
    gameboard.printStartGame()
    println( if (gameNumber == 1) "Single game" else "Total $gameNumber games" )
    gameboard.showBoard()
}

private fun initPlayers(): List<Player> {
    println("Connect Four")
    println("First player's name:")
    val players = mutableListOf(Player(readln(), "o"))
    println("Second player's name:")
    players.add(Player(readln(), "*"))
    return players.toList()
}

private fun howManyGames(): Int {
    while (true) {
        println("Do you want to play single or multiple games?\n" +
                "For a single game, input 1 or press Enter\n" +
                "Input a number of games:")
        val number = readln()
        when {
            number == "" -> return 1
            !Regex("[1-9]").matches(number) -> {
                println("Invalid input")
                continue
            }
            else -> return number.toInt()
        }
    }
}