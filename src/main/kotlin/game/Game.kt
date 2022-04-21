package game

import block_factory.BlockCreator
import blocks.Block
import board.Board
import game.exceptions.BlockCanMoveDownException
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import movements.Rotation
import score.Points
import score.ScoreCalculator

internal const val GAME_COLUMNS = 10
internal const val GAME_ROWS = 20
internal const val DEFAULT_POINTS = 0

class Game(private val creator: BlockCreator, private val scoreCalculator: ScoreCalculator) {

    private val board: Board = Board(GAME_ROWS, GAME_COLUMNS)
    private var block: Block? = null
    private var points: Points = Points(DEFAULT_POINTS)

    fun getGrid(): List<List<GameCell>> {
        val result = getGameCellGridFromBoard()
        if (block != null)
            block!!.getNeededPositions()
                .forEach { result[it.row][it.column] = GameCell(block!!.getCell(), isCurrentBlockCell = true) }
        return result
    }

    fun generateNextBlock() {
        block = creator.getBlock()
    }

    fun moveBlock(direction: Direction) {
        assertBlockNotNull()
        if (blockIsInValidPosition(block!!.move(direction)))
            block = block!!.move(direction)
    }

    fun rotateBlock(rotation: Rotation) {
        assertBlockNotNull()
        if (blockIsInValidPosition(block!!.rotate(rotation)))
            block = block!!.rotate(rotation)
    }

    fun blockCanMoveDownNext(): Boolean {
        assertBlockNotNull()
        return blockIsInValidPosition(block!!.move(Direction.DOWN))
    }

    fun writeBlockToBoard() {
        assertBlockNotNull()
        if (blockCanMoveDownNext())
            throw BlockCanMoveDownException("Block can move down next, so it's impossible to write it to the board")
        block!!.getNeededPositions().forEach { board.writePosition(block!!.getCell(), it) }
        checkIfCompletedRows()
    }

    fun hasFinished(): Boolean {
        assertBlockNotNull()
        return !blockIsInValidPosition(block!!)
    }

    fun getScore(): Points {
        return points
    }

    private fun assertBlockNotNull() {
        if (block == null)
            throw EmptyCurrentBlockException("Did you initialize a block with getNextBlock()?")
    }

    private fun getGameCellGridFromBoard(): MutableList<MutableList<GameCell>> {
        val immutableBoardGameCell = board.board.map { row -> row.map { cell -> GameCell(cell) } }
        return immutableBoardGameCell.map { it.toMutableList() }.toMutableList()
    }

    private fun blockIsInValidPosition(block: Block) =
        block.getNeededPositions().all { board.isInside(it) && board.isEmpty(it) }

    private fun checkIfCompletedRows() {
        if (hasCompletedRows()) {
            updateScore()
            board.redoBoardWithClearedCells()
        }
    }

    private fun hasCompletedRows() = (0 until GAME_ROWS).any { row -> board.isFull(row) }

    private fun getCompletedRows() = (0 until GAME_ROWS).count { row -> board.isFull(row) }

    private fun updateScore() {
        points = points.add(scoreCalculator.getScore(getCompletedRows()))
    }
}