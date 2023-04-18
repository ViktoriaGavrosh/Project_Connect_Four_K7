package connectfour

class GameBoard(private val players: List<Player>) {
    private val sizeBoard = readSizeBoard()
    val board: MutableList<MutableList<Square>> = fillBoard(sizeBoard[2].digitToInt(), sizeBoard[0].digitToInt())

    fun showBoard() {
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

    fun printStartGame() {
        println("${players[0].name} VS ${players[1].name}\n${sizeBoard[0]} X ${sizeBoard[2]} board")
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



    private fun fillBoard(rows: Int, places: Int): MutableList<MutableList<Square>> {
        val listS = MutableList(rows) {MutableList(places) {Square(1, 1)} }
        for (i in 0 until rows) {
            for (j in 0 until places) {
                listS[i][j] = Square(i + 1, j + 1 )
            }
        }
        return listS
    }
}