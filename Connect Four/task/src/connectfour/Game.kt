package connectfour

class Game(private val players: MutableList<Player>) {
    private val board: MutableList<MutableList<Square>>
    init {
        val text = readSizeBoard()
        printStartGame(players[0].name, players[1].name, text)
        board = fillBoard(text[2].digitToInt(), text[0].digitToInt())
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
        val listS = MutableList(rows) {MutableList<Square>(places) {Square(1, 1)} }
        for (i in 0..rows) {
            for (j in 0..places) {
                listS[i][j] = Square(i + 1, j + 1 )
            }
        }
        return listS
    }
}