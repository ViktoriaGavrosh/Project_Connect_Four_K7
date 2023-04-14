package connectfour

class Game(_players: MutableList<Player>) {
    private val players = _players
    private val board: MutableList<MutableList<Square>>
    init {
        val text = readSizeBoard()
        printStartGame(players[0].name, players[1].name, text)
        board = fillBoard(text[2].digitToInt(), text[0].digitToInt())
        showBoard()
    }
    var activePlayer = players[0]

    fun determineWinner(): Player {
        while (true) {
            println("${activePlayer.name}'s turn:")
            val move = readMove()
            when {
                move == "end" -> break
                move == "" -> continue

                }
            }

            moveTransition()
        }
        println("Game over!")
        return activePlayer
    }

    private fun readMove(): String {
        val move: String = readln()
        return when {
            move == "end" ->  move
            !Regex("\\d").matches(move) -> {
                println("Incorrect column number")
                ""
            }
            move.toInt() !in (1..this.board.size) -> {
                println("The column number is out of range (1 - ${this.board.size}")
                ""
            }
            !putChip(move.toInt()) -> {
                println("Column $move is full")
                ""
            }
            else -> move
        }
    }

    private fun putChip(column: Int): Boolean {

    }

    private fun moveTransition() {
        activePlayer = if (activePlayer == players[0]) players[1] else players[0]
    }

    private fun readSizeBoard(): String {
        var result: String
        while (true) {
            println("Set the board dimensions (Rows x Columns)\nPress Enter for default (6 x 7)")
            result = readln()
            if (result == "") {
                result = "6X7"
                break
            }
            val res = result.filter { it.isLetterOrDigit() }.uppercase()
            when {
                !Regex("\\d+X\\d+").matches(res) -> {
                    println("Invalid input")
                    continue
                }
                res.indexOf('X') != 1 || !Regex("[5-9][\\s\\S]*").matches(res) -> {
                    println("Board rows should be from 5 to 9")
                    continue
                }
                res.length > 3 || !Regex("[\\s\\S]*[5-9]").matches(res) -> {
                    println("Board columns should be from 5 to 9")
                    continue
                }
                !Regex(".X.").matches(res) -> {
                    println("Invalid input")
                    continue
                }
                else -> {
                    result = res
                    break
                }
            }
        }
        return result
    }

    private fun printStartGame(firstPlayer: String, secondPlayer: String, text: String) {
        println("$firstPlayer VS $secondPlayer\n${text[0]} X ${text[2]} board")
    }

    private fun fillBoard(rows: Int, places: Int): MutableList<MutableList<Square>> {
        val listS = MutableList(rows) {MutableList(places) {Square(1, 1)} }
        for (i in 0..rows - 1) {
            for (j in 0..places - 1) {
                listS[i][j] = Square(i + 1, j + 1 )
            }
        }
        return listS
    }

    private fun showBoard() {
        for (i in 1..board.size) print(" $i")
        for (j in board[0].size - 1 downTo 0) {
            print("\n|")
            for (i in 0..board.size - 1) print("${board[i][j]}|")
        }
        print("\n=")
        repeat(board.size) {
            print("==")
        }
    }
}