package connectfour

class HorizontalLineWin(board: MutableList<MutableList<Square>>, activeSquare: Square): Win(board, activeSquare) {
    override fun buildLine(): String {
        return board[activeSquare.line - 1].joinToString {""}
    }
}