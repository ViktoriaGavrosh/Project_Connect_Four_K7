package connectfour

import connectfour.checkWin.CheckerWin

class Game(private val players: List<Player>, gameNumber: Int, sizeBoard: String) {
    private val gameBoard: GameBoard
    init {
        gameBoard = GameBoard(sizeBoard)
        gameBoard.showBoard()
    }
    private var activePlayer = if (gameNumber % 2 != 0) players[0] else players[1]
    private val checker = CheckerWin(gameBoard.board[0][0], players)

    fun play() {
        while (true) {
            println("${activePlayer.name}'s turn:")
            when (readMove()) {
                "end" -> break
                "" -> continue
                else -> moveTransition()
            }
        }
    }

    private fun readMove(): String {
        val move: String = readln()
        return when {
            move == "end" ->  move
            !Regex("\\d+").matches(move) -> {
                println("Incorrect column number")
                ""
            }
            move.toInt() !in (1..gameBoard.board.size) -> {
                println("The column number is out of range (1 - ${gameBoard.board.size})")
                ""
            }
            !putChip(move.toInt()) -> {
                println("Column $move is full")
                ""
            }
            checker.checkWinAndDraw(gameBoard.board) -> "end"
            else -> move
        }
    }

    private fun putChip(column: Int): Boolean {
        var count = 0
        for (i in gameBoard.board[column - 1]) if (i.chip == " ") {
            i.chip = activePlayer.chip
            i.owner = activePlayer
            count++
            checker.activeSquare = i
            gameBoard.showBoard()
            break
        }
        return count == 1
    }

    private fun moveTransition() {
        activePlayer = if (activePlayer == players[0]) players[1] else players[0]
    }
}