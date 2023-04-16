package connectfour

class HorizontalLineWin : Win() {
    override fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String {
        var text = ""
        for (i in board[activeSquare.line - 1]) {
            text += i.chip
        }
        return text
    }
}