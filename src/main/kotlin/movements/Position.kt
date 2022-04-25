package movements

import java.io.Serializable

data class Position(val row: Int, val column: Int): Serializable {

    fun move(direction: Direction): Position {
        return when (direction) {
            Direction.DOWN -> Position(row + 1, column)
            Direction.LEFT -> Position(row, column - 1)
            Direction.RIGHT -> Position(row, column + 1)
            Direction.UP -> Position(row - 1, column)
        }
    }

    fun addAxes(other: Position): Position = Position(row + other.row, column + other.column)

}
