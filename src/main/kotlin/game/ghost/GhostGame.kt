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

    override fun getGrid(): List<List<GameCell>> = getGridWithGhostBlock(game.getGrid())

    override fun generateNextBlock() = game.generateNextBlock()

    override fun moveBlock(direction: Direction) = game.moveBlock(direction)

    override fun rotateBlock(rotation: Rotation) = game.rotateBlock(rotation)

    override fun blockCanMoveDownNext(): Boolean = game.blockCanMoveDownNext()

    override fun writeBlockToBoard() = game.writeBlockToBoard()

    override fun hasFinished(): Boolean = game.hasFinished()

    override fun getScore(): Points = game.getScore()

    private fun getGridWithGhostBlock(grid: List<List<GameCell>>): List<List<GameCell>> {
        val positionsCurrentBlock = getCurrentBlockPositions(grid)
        if (positionsCurrentBlock.isEmpty()) return grid
        return getGridWithGhostBlock(grid, positionsCurrentBlock)
    }

    private fun getCurrentBlockPositions(grid: List<List<GameCell>>): List<Position> =
        grid.flatMapIndexed { row, gameCells ->
            gameCells.indices.filter { column -> grid[row][column].isCurrentBlockCell }
                .map { column -> Position(row, column) }
        }

    private fun getGridWithGhostBlock(grid: List<List<GameCell>>, positions: List<Position>): List<List<GameCell>> {
        val moveDistance = positions.getRowOffset(grid)
        val ghostGrid = grid.toMutableList().map { it.toMutableList() }
        positions.filter { grid[it.row + moveDistance][it.column].cell == Cell.EMPTY }
            .map { Pair(Position(it.row + moveDistance, it.column), grid[it.row][it.column]) }
            .forEach { ghostGrid[it.first.row][it.first.column] = GameCell(it.second.cell, false, true) }
        return ghostGrid
    }

}