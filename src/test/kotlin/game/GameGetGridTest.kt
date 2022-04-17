package game

import block_factory.BlockCreator
import block_factory.BlockType
import blocks.implementation.IBlock
import board.Cell
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator

class GameGetGridTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
            override fun getNextBlockType(): BlockType = TODO("Not yet implemented")
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
    }

    @Test
    fun `new game returns empty grid`() {
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `get grid after first get block`() {
        game.getNextBlock()
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }

}