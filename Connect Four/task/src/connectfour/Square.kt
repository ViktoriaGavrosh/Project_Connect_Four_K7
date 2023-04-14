package connectfour

class Square(val line: Int, val place: Int) {
    var owner: Player? = null
    var chip: String = " "
    override fun toString(): String {
        return chip
    }

}