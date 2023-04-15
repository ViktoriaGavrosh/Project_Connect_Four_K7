package connectfour

class LeftDiagonalLineWin(board: MutableList<MutableList<Square>>, activeSquare: Square): Win(board, activeSquare) {
    override fun buildLine(): String {
        val startSquare = findStartSquare()
        var text = ""
        for (i in startSquare[0]until board.size) {
            for (j in startSquare[1] until board[0].size) {
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
}