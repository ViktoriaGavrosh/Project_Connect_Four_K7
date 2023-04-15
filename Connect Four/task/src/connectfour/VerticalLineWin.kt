package connectfour

class VerticalLineWin(board: MutableList<MutableList<Square>>, activeSquare: Square): Win(board, activeSquare) {
    override fun buildLine(): String {
        var text = ""
        for (i in board.indices) text += board[i][activeSquare.place - 1].toString()
        return text
    }
}