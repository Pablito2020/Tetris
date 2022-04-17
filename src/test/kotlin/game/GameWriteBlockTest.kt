package game

import block_factory.BlockCreator
import blocks.implementation.IBlock
import board.Cell
import game.exceptions.BlockCanMoveDownException
import game.exceptions.EmptyCurrentBlockException
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator

class GameWriteBlockTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
    }

    @Test
    fun `non initialized block should not be written`() {
        Assertions.assertThrows(EmptyCurrentBlockException::class.java) {
            game.writeBlockToBoard()
        }
    }

    @Test
    fun `new block that can move next should not be written`() {
        game.getNextBlock()
        Assertions.assertThrows(BlockCanMoveDownException::class.java) {
            game.writeBlockToBoard()
        }
    }

    @Test
    fun `block that can be written and it writes appears as a new cell`() {
        // Create first block, move it down, write it, and then get a new one
        game.getNextBlock()
        for( i in 1 until GAME_ROWS - 1)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        game.getNextBlock()
        // Expected: block saved at the bottom, and a new (current) block at the top
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, false)
        expectedGrid[1][(GAME_COLUMNS / 2) - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) - 1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2)] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][(GAME_COLUMNS / 2) + 1] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }

}