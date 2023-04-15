package connectfour

class RightDiagonalLineWin(board: MutableList<MutableList<Square>>, activeSquare: Square): Win(board, activeSquare) {
    override fun buildLine(): String {
        val startSquare = findSquare(activeSquare.line, activeSquare.place)
        val finishSquare = findSquare(activeSquare.place, activeSquare.line)
        var text = ""
        for (i in startSquare[0] until finishSquare[0]) {
            for (j in startSquare[1] downTo finishSquare[1]) {
                text += board[i][j].toString()
            }
        }
        return text
    }

    private fun findSquare(first: Int, second: Int): MutableList<Int> {
        val result = mutableListOf(first, second)
        result[0] = --result[0]
        result[1] = --result[1]
        while (true) {
            if (result[0] == 0 || result[1] == board[0].size - 1) return result
            result[0] = --result[0]
            result[1] = ++result[1]
        }
    }

}