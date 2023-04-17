package connectfour.checkWin

import connectfour.Square

class VerticalLineWin : Win() {
    override fun buildLine(board: MutableList<MutableList<Square>>, activeSquare: Square): String {
        var text = ""
        for (i in board.indices) text += board[i][activeSquare.place - 1].toString()
        return text
    }
}