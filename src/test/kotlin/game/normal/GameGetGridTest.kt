package game.normal

import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import game.GameCell
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator

class GameGetGridTest {

    private lateinit var game: NormalGame

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        game = NormalGame(blockCreator, scoreCalculator)
    }

    @Test
    fun `new game returns empty grid`() {
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `get grid after first get block`() {
        game.generateNextBlock()
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }

}