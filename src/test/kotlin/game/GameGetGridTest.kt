package game

import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator

class GameGetGridTest {

    @Test
    fun `new game returns empty grid`() {
        val game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(GAME_CELL_BUFFER, (GAME_COLUMNS / 2) - 2))
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `get grid after first get block`() {
        val game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(GAME_CELL_BUFFER, (GAME_COLUMNS / 2) - 2))
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
        game.getNextBlock()
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[GAME_CELL_BUFFER + 1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_CELL_BUFFER + 1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_CELL_BUFFER + 1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_CELL_BUFFER + 1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }

}