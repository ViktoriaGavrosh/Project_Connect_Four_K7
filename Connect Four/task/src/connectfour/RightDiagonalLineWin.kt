package connectfour

class RightDiagonalLineWin: Win() {
    override fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String {
        val startSquare = findStartSquare(activeSquare.line, activeSquare.place, board)
        val finishSquare = findFinishSquare(activeSquare.place, activeSquare.line, board)
        var text = ""
        println("start ${startSquare.joinToString()} finish ${finishSquare.joinToString()}")
        for (i in startSquare[0]..finishSquare[0]) {  //проходит 9 раз вместо 3
            for (j in startSquare[1] downTo finishSquare[1]) {
                text += board[i][j].toString()
                println("print $text")
            }
        }
        return text
    }

    private fun findStartSquare(first: Int, second: Int, board: MutableList<MutableList<Square>>): MutableList<Int> {
        val result = mutableListOf(first, second)
        result[0] = --result[0]
        result[1] = --result[1]
        while (true) {
            if (result[0] == 0 || result[1] == board[0].size - 1) return result
            result[0] = --result[0]
            result[1] = ++result[1]
        }
    }

    private fun findFinishSquare(first: Int, second: Int, board: MutableList<MutableList<Square>>): MutableList<Int> {
        val result = mutableListOf(first, second)
        result[0] = --result[0]
        result[1] = --result[1]
        while (true) {
            if (result[0] == board[0].size - 1 || result[1] == 0) return result
            result[0] = ++result[0]
            result[1] = --result[1]
        }
    }

}