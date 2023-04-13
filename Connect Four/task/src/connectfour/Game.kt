package connectfour

class Game {
    private var firstPlayer: Player
    private var secondPlayer: Player
    init {
        println("Connect Four")
        println("First player's name:")
        firstPlayer = Player(readln())
        println("Second player's name:")
        secondPlayer = Player(readln())
    }
    fun start() {
        val text = buildBoard()
        printStartGame(firstPlayer.name, secondPlayer.name, text)
    }

    private fun buildBoard(): String {
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
}