package game

import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator

class MoveBlockCollisionOutOfBoundsTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        game = Game(blockCreator, scoreCalculator)
    }

    @Test
    fun `move block fi not getted the first one raises an exception`() {
        Assertions.assertThrows(EmptyCurrentBlockException::class.java) {
            game.moveBlock(Direction.RIGHT)
        }
    }

    @Test
    fun `move block to right changes board one position to right`() {
        game.getNextBlock()
        game.moveBlock(Direction.RIGHT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 2] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `move block to left changes board one position to left`() {
        game.getNextBlock()
        game.moveBlock(Direction.LEFT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][(GAME_COLUMNS / 2) - 3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `move block to down changes board one position to down`() {
        game.getNextBlock()
        game.moveBlock(Direction.DOWN)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[2][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `move block to up changes board one position to up`() {
        game.getNextBlock()
        game.moveBlock(Direction.UP)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[0][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[0][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[0][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[0][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `move block to left if it is out of bounds doesn't changes block position`() {
        game.getNextBlock()
        // move block to the left of the board
        for (i in 0 until (GAME_COLUMNS / 2) - 2)
            game.moveBlock(Direction.LEFT)
        // move block out of bounds
        game.moveBlock(Direction.LEFT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][0] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][3] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `move block to right if it is out of bounds doesn't changes block position`() {
        game.getNextBlock()
        // move block to the left of the board
        for (i in 0 until (GAME_COLUMNS / 2) - 2)
            game.moveBlock(Direction.RIGHT)
        // move block out of bounds
        game.moveBlock(Direction.RIGHT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[1][GAME_COLUMNS - 4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][GAME_COLUMNS - 3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][GAME_COLUMNS - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][GAME_COLUMNS - 1] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `move block to down doesn't do anything if it is out of bounds`() {
        game.getNextBlock()
        // move block to the left of the board
        for (i in 1 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        // move block out of bounds
        game.moveBlock(Direction.DOWN)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

}