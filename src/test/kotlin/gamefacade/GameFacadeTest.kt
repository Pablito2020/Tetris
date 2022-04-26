package blocks.gamefacade

import GameFacade
import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import game.GameCell
import game.normal.GAME_COLUMNS
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito
import score.ScoreCalculator
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GameFacadeTest {

    private lateinit var gameFacade: GameFacade

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
            .thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        gameFacade = GameFacade(blockCreator, scoreCalculator)
    }

    @Test
    fun `uninitialized game doesn't throw exception when initialized`() {
        assertDoesNotThrow { gameFacade.start() }
    }

    @Test
    fun `initialized game throws IllegalAccessError when initialized`() {
        gameFacade.start()
        assertFailsWith<IllegalAccessError> { gameFacade.start() }
    }

    @Test
    fun `drop the block moves the block down the grid`() {
        gameFacade.start()
        gameFacade.dropBlock()
        val expected = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY, false, false) } }
        // actual I Block
        expected[1][3] = GameCell(Cell.I_BLOCK, true, false)
        expected[1][4] = GameCell(Cell.I_BLOCK, true, false)
        expected[1][5] = GameCell(Cell.I_BLOCK, true, false)
        expected[1][6] = GameCell(Cell.I_BLOCK, true, false)
        // saved I block
        expected[19][3] = GameCell(Cell.I_BLOCK, false, false)
        expected[19][4] = GameCell(Cell.I_BLOCK, false, false)
        expected[19][5] = GameCell(Cell.I_BLOCK, false, false)
        expected[19][6] = GameCell(Cell.I_BLOCK, false, false)
        assertEquals(expected, gameFacade.getGrid())
    }

}