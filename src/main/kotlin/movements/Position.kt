package movements

data class Position(val row: Int, val column: Int) {

    fun move(direction: Direction): Position {
        return when(direction) {
            Direction.DOWN -> Position(row, column + 1)
            Direction.LEFT -> Position(row - 1, column)
            Direction.RIGHT -> Position(row + 1, column)
        }
    }

}
