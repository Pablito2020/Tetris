package game.normal

import block_factory.BlockCreator
import block_factory.BlockType
import blocks.implementation.IBlock
import board.Cell
import game.GameCell
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

    private lateinit var game: NormalGame

    @BeforeEach
    fun setUp() {

        game = NormalGame(object : BlockCreator {
            override fun getBlock() = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
            override fun getNextBlockType(): BlockType = TODO("Not yet implemented")
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
        game.generateNextBlock()
        Assertions.assertThrows(BlockCanMoveDownException::class.java) {
            game.writeBlockToBoard()
        }
    }

    @Test
    fun `block that can be written and it writes appears as a new cell`() {
        // Create first block, move it down, write it, and then get a new one
        game.generateNextBlock()
        for (i in 1 until GAME_ROWS - 1)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        game.generateNextBlock()
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