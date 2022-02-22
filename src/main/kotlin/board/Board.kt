package board

import board.exceptions.InvalidPositionException
import board.exceptions.InvalidRowException
import movements.Position

class Board(private val row: Int, private val column: Int) {

    val board = MutableList(row) { MutableList(column) { Cell.EMPTY } }

    fun isInside(position: Position) = isValidRow(position.row) && isValidColumn(position.column)

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
        if (!isValidRow(row))
            throw InvalidRowException()
        return board[row].all { x -> x != Cell.EMPTY }
    }

    fun clear(row: Int) {
        if (!isValidRow(row))
            throw InvalidRowException()
        board[row] = MutableList(this.column) { Cell.EMPTY }
    }

    private fun isValidRow(row: Int) = row >= 0 && row < this.row

    private fun isValidColumn(column: Int) = column >= 0 && column < this.column

}