package movements

data class Position(val row: Int, val column: Int) {

    fun move(direction: Direction): Position {
        return when(direction) {
            Direction.DOWN -> Position(row + 1, column)
            Direction.LEFT -> Position(row, column - 1)
            Direction.RIGHT -> Position(row , column + 1)
        }
    }

}
