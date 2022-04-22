package game.ghost

import board.Cell
import game.GameCell
import movements.Position

internal fun Position.getLastEmptyBlock(grid: List<List<GameCell>>): Position {
    var varRow = this.row
    while (varRow < grid.size && (grid[varRow][column].cell == Cell.EMPTY || grid[varRow][column].isCurrentBlockCell))
        varRow += 1
    return Position(varRow - 1, column)
}

internal fun List<Position>.getRowOffset(grid: List<List<GameCell>>): Int {
    val minimum = this.minByOrNull{ it.getLastEmptyBlock(grid).row - it.row }
    return minimum!!.getLastEmptyBlock(grid).row - minimum.row
}
