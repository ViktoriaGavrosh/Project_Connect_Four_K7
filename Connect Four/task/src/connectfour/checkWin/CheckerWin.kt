package connectfour.checkWin

import connectfour.*

class CheckerWin(square: Square) {
    var activeSquare = square
    private val listWin = buildList {
        add(HorizontalLineWin())
        add(VerticalLineWin())
        add(LeftDiagonalLineWin())
        add(RightDiagonalLineWin())
    }

    fun checkWinAndDraw(board: MutableList<MutableList<Square>>): Boolean {
        for (i in listWin) if (i.checkWinner(board, activeSquare)) return true
        return checkDraw(board)
    }

    private fun checkDraw(board: MutableList<MutableList<Square>>): Boolean {
        for (i in board) if (i.last().chip == " ") return false
        println("It is a draw")
        return true
    }
}