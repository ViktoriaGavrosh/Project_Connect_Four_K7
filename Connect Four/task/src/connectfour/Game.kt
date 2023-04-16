package connectfour

class Game(twoPlayers: MutableList<Player>) {
    private val players = twoPlayers
    private val board: MutableList<MutableList<Square>>
    init {
        val text = readSizeBoard()
        printStartGame(players[0].name, players[1].name, text)
        board = fillBoard(text[2].digitToInt(), text[0].digitToInt())
        showBoard()
    }
    private var activePlayer = players[0]
    private val checker = CheckerWin(board[0][0])


    fun determineWinner(): Player {
        while (true) {
            println("${activePlayer.name}'s turn:")
            when (readMove()) {
                "end" -> break
                "" -> continue
                else -> moveTransition()
            }
        }
        println("Game over!")
        return activePlayer
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
        for (i in 0 until rows) {
            for (j in 0 until places) {
                listS[i][j] = Square(i + 1, j + 1 )
            }
        }
        return listS
    }

    private fun showBoard() {
        for (i in 1..board.size) print(" $i")
        for (j in board[0].size - 1 downTo 0) {
            print("\n|")
            for (i in 0 until board.size) print("${board[i][j]}|")
        }
        print("\n=")
        repeat(board.size) {
            print("==")
        }
        println("")
    }
}