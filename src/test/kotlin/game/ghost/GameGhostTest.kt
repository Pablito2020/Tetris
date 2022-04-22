package game.ghost

import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import game.normal.GAME_COLUMNS
import game.normal.GAME_ROWS
import game.GameCell
import movements.Position
import movements.Rotation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator

class GameGhostTest {

    private lateinit var game: GhostGame

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        game = GhostGame(blockCreator, scoreCalculator)
    }

    @Test
    fun `new game returns empty grid`() {
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `get grid after first get block, all in same row`() {
        game.generateNextBlock()
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // Actual Grid
        expectedGrid[1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        // Ghost
        expectedGrid[19][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[19][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[19][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[19][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, false, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `get grid after first get block, all in same column`() {
        game.generateNextBlock()
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // Actual Grid
        expectedGrid[0][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[3][4] = GameCell(Cell.I_BLOCK, true)
        // Ghost
        expectedGrid[16][4] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[17][4] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[18][4] = GameCell(Cell.I_BLOCK, false, true)
        expectedGrid[19][4] = GameCell(Cell.I_BLOCK, false, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

}