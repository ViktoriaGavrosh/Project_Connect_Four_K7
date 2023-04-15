package connectfour

class HorizontalLineWin : Win() {
    override fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String {
        return board[activeSquare.line - 1].joinToString {""}
    }
}