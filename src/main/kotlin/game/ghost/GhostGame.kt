package game.ghost

import block_factory.BlockCreator
import board.Cell
import game.Game
import game.GameCell
import game.normal.NormalGame
import movements.Direction
import movements.Position
import movements.Rotation
import score.Points
import score.ScoreCalculator

class GhostGame(creator: BlockCreator, scoreCalculator: ScoreCalculator) : Game {

    private val game = NormalGame(creator, scoreCalculator)

    override fun getGrid(): List<List<GameCell>> {
        val grid = game.getGrid().toMutableList().map { it.toMutableList() }
        return getGridWithGhostBlock(grid)
    }

    override fun generateNextBlock() = game.generateNextBlock()

    override fun moveBlock(direction: Direction) = game.moveBlock(direction)

    override fun rotateBlock(rotation: Rotation) = game.rotateBlock(rotation)

    override fun blockCanMoveDownNext(): Boolean = game.blockCanMoveDownNext()

    override fun writeBlockToBoard() = game.writeBlockToBoard()

    override fun hasFinished(): Boolean = game.hasFinished()

    override fun getScore(): Points = game.getScore()

    private fun getGridWithGhostBlock(grid: List<MutableList<GameCell>>): List<List<GameCell>> {
        // get current cells of the block
        val result = mutableListOf<Position>()
        for ((rowI, row) in grid.withIndex()) {
            for (column in row.indices) {
                if (grid[rowI][column].isCurrentBlockCell)
                    result.add(Position(rowI, column))
            }
        }
        if (result.isEmpty())
            return grid
        // get minimum row of current block
        val distance = result.getRowOffset(grid)
        // Write Result
        for (position in result) {
            val currentGhostBlock = GameCell(grid[position.row][position.column].cell, false, true)
            if (grid[position.row + distance][position.column].cell == Cell.EMPTY)
                grid[position.row + distance][position.column] = currentGhostBlock
        }
        return grid
    }

}