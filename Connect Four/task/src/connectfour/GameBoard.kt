package connectfour

class GameBoard(sizeBoard: String) {
    val board: MutableList<MutableList<Square>> = fillBoard(sizeBoard[2].digitToInt(), sizeBoard[0].digitToInt())

    fun showBoard() {
        for (i in 1..board.size) print(" $i")
        for (j in board[0].size - 1 downTo 0) {
            print("\n|")
            for (i in 0 until board.size) print("${board[i][j]}|")
        }
        print("\n=")
        repeat(board.size) {
            print("==")
        }
        println("")
    }

    private fun fillBoard(rows: Int, places: Int): MutableList<MutableList<Square>> {
        val listS = MutableList(rows) {MutableList(places) {Square(1, 1)} }
        for (i in 0 until rows) {
            for (j in 0 until places) {
                listS[i][j] = Square(i + 1, j + 1 )
            }
        }
        return listS
    }
}