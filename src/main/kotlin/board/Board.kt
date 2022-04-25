package board

import board.exceptions.InvalidPositionException
import board.exceptions.InvalidRowException
import movements.Position
import java.io.Serializable

class Board(private val row: Int, private val column: Int): Serializable {

    val board = MutableList(row) { MutableList(column) { Cell.EMPTY } }

    fun isInside(position: Position) = isValidRow(position.row) && isValidColumn(position.column)

    fun isEmpty(position: Position): Boolean {
        if (!isInside(position))
            throw InvalidPositionException()
        return board[position.row][position.column] == Cell.EMPTY
    }

    fun isClear(row: Int) = isValidRow(row) && board[row].all { it == Cell.EMPTY }

    fun redoBoardWithClearedCells() {
        var counterFull = 0
        for (currentRow in row - 1 downTo 0) {
            if (isClear(currentRow))
                break
            else if (isFull(currentRow)) {
                counterFull += 1
                clear(currentRow)
            } else {
                val temp = board[currentRow].toMutableList()
                clear(currentRow)
                board[currentRow + counterFull] = temp
            }
        }
    }

    fun writePosition(cell: Cell, position: Position) {
        if (!isInside(position))
            throw InvalidPositionException()
        board[position.row][position.column] = cell
    }

    fun isFull(row: Int): Boolean {
        if (!isValidRow(row))
            throw InvalidRowException("row: $row")
        return board[row].all { x -> x != Cell.EMPTY }
    }

    fun clear(row: Int) {
        if (!isValidRow(row))
            throw InvalidRowException()
        board[row] = MutableList(this.column) { Cell.EMPTY }
    }

    private fun isValidRow(row: Int) = row >= 0 && row < this.row

    private fun isValidColumn(column: Int) = column >= 0 && column < this.column

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Board
        if (row != other.row || column != other.column || board != other.board) return false
        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        result = 31 * result + board.hashCode()
        return result
    }


}