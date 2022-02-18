package board

import movements.Position

class Board(private val row: Int, private val column: Int) {

    fun isInside(position: Position) = hasPositiveRowsAndColumns(position) && isInsideDefaultMatrix(position)

    private fun hasPositiveRowsAndColumns(position: Position) = position.row >= 0 && position.column >= 0

    private fun isInsideDefaultMatrix(position: Position) = position.column < this.column && position.row < this.row

}
