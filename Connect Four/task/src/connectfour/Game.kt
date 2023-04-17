package connectfour

import connectfour.checkWin.CheckerWin

class Game(private val twoPlayers: List<Player>, number: Int, private val board: MutableList<MutableList<Square>>) {
    private val gameNumber = number
    private val players = twoPlayers
    private var activePlayer = if (gameNumber % 2 != 0) players[0] else players[1]
    private val checker = CheckerWin(board[0][0])

    fun play() {
        while (true) {
            println("${activePlayer.name}'s turn:")
            when (readMove()) {
                "end" -> break
                "" -> continue
                else -> moveTransition()
            }
        }
        println("Game over!")
    }

    private fun readMove(): String {
        val move: String = readln()
        return when {
            move == "end" ->  move
            !Regex("\\d+").matches(move) -> {
                println("Incorrect column number")
                ""
            }
            move.toInt() !in (1..board.size) -> {
                println("The column number is out of range (1 - ${board.size})")
                ""
            }
            !putChip(move.toInt()) -> {
                println("Column $move is full")
                ""
            }
            checker.checkWinAndDraw(board) -> "end"
            else -> move
        }
    }

    private fun putChip(column: Int): Boolean {
        var count = 0
        for (i in board[column - 1]) if (i.chip == " ") {
            i.chip = activePlayer.chip
            i.owner = activePlayer
            count++
            checker.activeSquare = i
            showBoard()
            break
        }
        return count == 1
    }

    private fun moveTransition() {
        activePlayer = if (activePlayer == players[0]) players[1] else players[0]
    }
}