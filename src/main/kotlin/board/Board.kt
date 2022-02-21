package board

import board.exceptions.InvalidPositionException
import board.exceptions.InvalidRowException
import movements.Position

class Board(private val row: Int, private val column: Int) {

    val board = MutableList(row) { MutableList(column) { Cell.EMPTY } }

    fun isInside(position: Position) = hasPositiveRowsAndColumns(position) && isInsideDefaultMatrix(position)

    private fun hasPositiveRowsAndColumns(position: Position) = position.row >= 0 && position.column >= 0

    private fun isInsideDefaultMatrix(position: Position) = position.column < this.column && position.row < this.row

    fun isEmpty(position: Position): Boolean {
        if (!isInside(position))
            throw InvalidPositionException()
        return board[position.row][position.column] == Cell.EMPTY
    }

    fun writePosition(cell: Cell, position: Position) {
        if (!isInside(position))
            throw InvalidPositionException()
        board[position.row][position.column] = cell
    }

    fun isFull(row: Int): Boolean {
        if (row < 0 || row >= this.row)
            throw InvalidRowException()
        return board[row].all { x -> x != Cell.EMPTY }
    }

}
