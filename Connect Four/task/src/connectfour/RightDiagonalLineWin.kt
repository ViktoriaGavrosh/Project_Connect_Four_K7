package connectfour

class RightDiagonalLineWin: Win() {
    override fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String {
        val startSquare = findSquare(activeSquare.line, activeSquare.place, board)
        val finishSquare = findSquare(activeSquare.place, activeSquare.line, board)
        var text = ""
        for (i in startSquare[0] until finishSquare[0]) {
            for (j in startSquare[1] downTo finishSquare[1]) {
                text += board[i][j].toString()
            }
        }
        return text
    }

    private fun findSquare(first: Int, second: Int, board: MutableList<MutableList<Square>>): MutableList<Int> {
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