package connectfour

fun main() {
    start()
}

fun start() {
    println("Connect Four")
    println("First player's name:")
    val firstPlayer = readln()
    println("Second player's name:")
    val secondPlayer = readln()

    val text = buildBoard()
    printStartGame(firstPlayer, secondPlayer, text)
}

fun buildBoard(): String {
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
            !Regex(".X.").matches(res) -> {
                println("Invalid input")
                continue
            }
            !Regex("[5-9]..").matches(res) -> {
                println("Board rows should be from 5 to 9")
                continue
            }
            !Regex("..[5-9]").matches(res) -> {
                println("Board columns should be from 5 to 9")
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

fun printStartGame(firstPlayer: String, secondPlayer: String, text: String) {
    println("$firstPlayer VS $secondPlayer\n${text[0]} X ${text[2]} board")
}