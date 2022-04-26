package game.normal

import block_factory.BlockCreator
import blocks.Block
import board.Board
import game.Game
import game.GameCell
import game.exceptions.BlockCanMoveDownException
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import movements.Rotation
import score.Points
import score.ScoreCalculator
import java.io.Serializable

internal const val GAME_COLUMNS = 10
internal const val GAME_ROWS = 20
internal const val DEFAULT_POINTS = 0

internal class NormalGame(private val creator: BlockCreator, private val scoreCalculator: ScoreCalculator): Game, Serializable {

    private val board: Board = Board(GAME_ROWS, GAME_COLUMNS)
    private var block: Block? = null
    private var points: Points = Points(DEFAULT_POINTS)

    override fun getGrid(): List<List<GameCell>> {
        val result = getGameCellGridFromBoard()
        if (block != null)
            block!!.getNeededPositions()
                .forEach { result[it.row][it.column] = GameCell(block!!.getCell(), isCurrentBlockCell = true) }
        return result
    }

    override fun generateNextBlock() {
        block = creator.getBlock()
    }

    override fun moveBlock(direction: Direction) {
        assertBlockNotNull()
        if (blockIsInValidPosition(block!!.move(direction)))
            block = block!!.move(direction)
    }

    override fun rotateBlock(rotation: Rotation) {
        assertBlockNotNull()
        if (blockIsInValidPosition(block!!.rotate(rotation)))
            block = block!!.rotate(rotation)
    }

    override fun blockCanMoveDownNext(): Boolean {
        assertBlockNotNull()
        return blockIsInValidPosition(block!!.move(Direction.DOWN))
    }

    override fun writeBlockToBoard() {
        assertBlockNotNull()
        if (blockCanMoveDownNext())
            throw BlockCanMoveDownException("Block can move down next, so it's impossible to write it to the board")
        block!!.getNeededPositions().forEach { board.writePosition(block!!.getCell(), it) }
        checkIfCompletedRows()
    }

    override fun hasFinished(): Boolean {
        assertBlockNotNull()
        return !blockIsInValidPosition(block!!)
    }

    override fun getScore(): Points {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NormalGame
        if (board != other.board) return false
        if (block != other.block) return false
        if (points != other.points) return false
        return true
    }

    override fun hashCode(): Int {
        var result = board.hashCode()
        result = 31 * result + (block?.hashCode() ?: 0)
        result = 31 * result + points.hashCode()
        return result
    }

}