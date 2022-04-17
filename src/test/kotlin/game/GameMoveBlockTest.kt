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
import score.Points
import score.ScoreCalculator

class GameMoveBlockTest {

    private lateinit var game : Game

    @BeforeEach
    fun setUp() {
        game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
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

}