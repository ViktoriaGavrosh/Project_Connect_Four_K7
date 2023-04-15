package connectfour

abstract class Win(val board: MutableList<MutableList<Square>>, val activeSquare: Square) {
    var line: String = this.buildLine()
    val win1 = "oooo"
    val win2 = "****"

    abstract fun buildLine(): String

    fun checkWinner(): Boolean {
        val isWin = if (activeSquare.chip in win1) win1 in line else win2 in line
        if (isWin) {
            println("Player ${activeSquare.owner!!.name} won")
            return true
        }
        return false
    }
}