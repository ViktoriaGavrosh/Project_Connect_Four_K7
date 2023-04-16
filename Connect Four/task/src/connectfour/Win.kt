package connectfour

abstract class Win() {
    var line: String = ""
    val win1 = "oooo"
    val win2 = "****"

    abstract fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String

    fun checkWinner(board: MutableList<MutableList<Square>>, activeSquare: Square): Boolean {
        this.line = buildLine(board, activeSquare)
        val isWin = if (activeSquare.chip in win1) win1 in line else win2 in line
        if (isWin) {
            println("Player ${activeSquare.owner!!.name} won")
            return true
        }
        return false
    }
}