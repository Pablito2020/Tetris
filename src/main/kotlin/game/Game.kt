package game

import blocks.Block
import board.Board
import board.Cell

internal const val GAME_COLUMNS = 10
internal const val GAME_ROWS = 20
internal val GAME_CELL_BUFFER = 4

class Game(val creator: BlockCreator, val scoreCalculator: ScoreCalculator) {

    private val board: Board = Board(GAME_ROWS + GAME_CELL_BUFFER, GAME_COLUMNS)
    private var block: Block? = null

    // TODO: Need to be tested with different block types already saved on the board
    fun getGrid(): List<List<GameCell>> {
        val list = board.board.map { it.map { GameCell(it, false) } }
        val newList: MutableList<MutableList<GameCell>> = (list.subList(GAME_CELL_BUFFER, list.size)).map{ it.toMutableList() }.toMutableList()
        if (block != null)
            block!!.getNeededPositions().forEach { newList[it.row][it.column] = GameCell(block!!.getCell(), true) }
        return newList
    }

    fun getNextBlock() {
        block = creator.getBlock()
    }

}