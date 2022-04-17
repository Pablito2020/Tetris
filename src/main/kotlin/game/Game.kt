package game

import block_factory.BlockCreator
import blocks.Block
import board.Board
import game.exceptions.BlockCanMoveDownException
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import score.ScoreCalculator

internal const val GAME_COLUMNS = 10
internal const val GAME_ROWS = 20

class Game(private val creator: BlockCreator, val scoreCalculator: ScoreCalculator) {

    private val board: Board = Board(GAME_ROWS, GAME_COLUMNS)
    private var block: Block? = null

    fun getGrid(): List<List<GameCell>> {
        val result = getGameCellGridFromBoard()
        if (block != null)
            block!!.getNeededPositions().forEach { result[it.row][it.column] = GameCell(block!!.getCell(), true) }
        return result
    }

    fun getNextBlock() {
        block = creator.getBlock()
    }

    fun moveBlock(direction: Direction) {
        assertBlockNotNull()
        if (isValidBlockPosition(direction))
            block!!.move(direction)
    }

    fun blockCanMoveDownNext(): Boolean {
        assertBlockNotNull()
        return isValidBlockPosition(Direction.DOWN)
    }

    fun writeBlockToBoard() {
        assertBlockNotNull()
        if (blockCanMoveDownNext())
            throw BlockCanMoveDownException("Block can move down next, so it's impossible to write it to the board")
        block!!.getNeededPositions().forEach { board.writePosition(block!!.getCell(), it) }
    }

    private fun assertBlockNotNull() {
        if (block == null)
            throw EmptyCurrentBlockException("Did you initialize a block with getNextBlock()?")
    }

    private fun getGameCellGridFromBoard(): MutableList<MutableList<GameCell>> {
        val immutableBoardGameCell = board.board.map { row -> row.map { cell -> GameCell(cell, false) } }
        return immutableBoardGameCell.map { it.toMutableList() }.toMutableList()
    }

    private fun isValidBlockPosition(direction: Direction): Boolean {
        block!!.move(direction)
        val canMove = block!!.getNeededPositions().all { board.isInside(it) && board.isEmpty(it) }
        block!!.move(direction.opposite())
        return canMove
    }

}