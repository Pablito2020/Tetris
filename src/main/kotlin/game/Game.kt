package game

import block_factory.BlockCreator
import blocks.Block
import board.Board
import board.Cell
import game.exceptions.BlockCanMoveDownException
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import movements.Position
import score.ScoreCalculator

internal const val GAME_COLUMNS = 10
internal const val GAME_ROWS = 20
internal const val GAME_CELL_BUFFER = 4

class Game(private val creator: BlockCreator, val scoreCalculator: ScoreCalculator) {

    private val board: Board = Board(GAME_ROWS + GAME_CELL_BUFFER, GAME_COLUMNS)
    private var block: Block? = null

    // TODO: Need to be tested with different block types already saved on the board
    fun getGrid(): List<List<GameCell>> {
        val result = getMutableGrid()
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
        block!!.getBoardPositions().forEach { board.writePosition(block!!.getCell(), it) }
    }

    private fun Block.getBoardPositions() = getNeededPositions().map { it.addAxes(Position(GAME_CELL_BUFFER, 0)) }

    private fun assertBlockNotNull() {
        if (block == null)
            throw EmptyCurrentBlockException("Did you initialize a block with getNextBlock()?")
    }

    private fun getMutableGrid(): MutableList<MutableList<GameCell>> {
        val currentBoard: List<List<Cell>> = board.board
        return getGridFromBoard(currentBoard)
    }

    private fun getGridFromBoard(currentBoard: List<List<Cell>>): MutableList<MutableList<GameCell>> {
        val mappedBoard = currentBoard.map { row -> row.map { cell -> GameCell(cell, false) } }
        return mappedBoard.subList(GAME_CELL_BUFFER, mappedBoard.size).map { it.toMutableList() }.toMutableList()
    }

    private fun isValidBlockPosition(direction: Direction): Boolean {
        block!!.move(direction)
        val canMove = block!!.getBoardPositions().all { board.isInside(it) && board.isEmpty(it) }
        block!!.move(direction.opposite())
        return canMove
    }

}