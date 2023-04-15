package connectfour

class LeftDiagonalLineWin(board: MutableList<MutableList<Square>>, activeSquare: Square): Win(board, activeSquare) {
    override fun buildLine(): String {
        val startSquare = findStartSquare()
        val finishSquare = findFinishSquare()
        var text = ""
        for (i in startSquare[0]..finishSquare[0]) {
            for (j in startSquare[1]..finishSquare[1]) {
                text += board[i][j].toString()
            }
        }
        return text
    }

    private fun findStartSquare(): MutableList<Int> {
        val result = mutableListOf(activeSquare.line, activeSquare.place)
        while (true) {
            result[0] = --result[0]
            result[1] = --result[1]
            if (result[0] == 0 || result[1] == 0) return result
        }
    }

    private fun findFinishSquare(): MutableList<Int> {
        val result = mutableListOf(activeSquare.line, activeSquare.place)
        result[0] = --result[0]
        result[1] = --result[1]
        while (true) {
            if (result[0] == board.size - 1 || result[1] == board[0].size - 1) return result
            result[0] = ++result[0]
            result[1] = ++result[1]
        }
    }
}