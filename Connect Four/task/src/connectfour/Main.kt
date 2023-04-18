package connectfour

import java.time.temporal.TemporalAmount

fun main() {
    Main().start()
}

class Main {
    private val players = initPlayers()
    private val sizeBoard = readSizeBoard()
    private var gameAmount: Int = howManyGames()
    
    fun start() {
        startGame()
        var isEnd: Boolean
        for (i in 1..gameAmount) {
            if (gameAmount > 1) println("Game #$i")
            isEnd = Game(players, i, sizeBoard).play()
            if (isEnd) break
            if (gameAmount > 1) printScore()
        }
        println("Game over!")
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

    private fun startGame() {
        printStartGame()
        println(if (gameAmount == 1) "Single game" else "Total $gameAmount games")
    }

    private fun printStartGame() {
        println("${players[0].name} VS ${players[1].name}\n${sizeBoard[0]} X ${sizeBoard[2]} board")
    }

    private fun printScore() {
        println("Score\n${players[0].name}: ${players[0].points} ${players[1].name}: ${players[1].points}")
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
            println(
                "Do you want to play single or multiple games?\n" +
                        "For a single game, input 1 or press Enter\n" +
                        "Input a number of games:"
            )
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
}    