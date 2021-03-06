package game.normal

import block_factory.BlockCreator
import blocks.implementation.IBlock
import blocks.implementation.SquareBlock
import board.Cell
import game.GameCell
import movements.Direction
import movements.Position
import movements.Rotation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator

class RotationBlockCollisionCellTest {

    private lateinit var game: NormalGame

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock())
            .thenReturn(SquareBlock(Position(0, (GAME_COLUMNS / 2) - 1)))
            .thenReturn(SquareBlock(Position(0, (GAME_COLUMNS / 2) - 1)))
            .thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        game = NormalGame(blockCreator, Mockito.mock(ScoreCalculator::class.java))
        moveSquaresDown()
    }

    private fun moveSquaresDown() {
        // generate, move squares blocks down and save it to the board
        (0 until 2).forEach { _ ->
            game.generateNextBlock()
            (0 until GAME_ROWS).forEach { _ ->
                game.moveBlock(Direction.DOWN)
            }
            game.writeBlockToBoard()
        }
        game.generateNextBlock()
    }

    @Test
    fun `rotate 90 degrees left shouldn't do anything if there is a collision cell`() {
        /*
        Rotate I block 90 degrees right, move it to the right of the board and then
        near the Square Block, then try to rotate (it shouldn't do anything), the table should be:
        |0123456789|
        |----------|
        |          | 0
        |..........| ...
        |      i   | 15
        |    ssi   | 16
        .    ssi   | 17
        |    ssi   | 18
        |    ss    | 19
        |----------|
         */
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        game.moveBlock(Direction.RIGHT)
        for (i in 0 until 15)
            game.moveBlock(Direction.DOWN)
        // Rotation which shouldn't do anything
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square blocks
        expectedGrid[GAME_ROWS - 4][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 4][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 3][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 3][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.SQUARE_BLOCK, false)
        // i block
        expectedGrid[GAME_ROWS - 5][6] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 4][6] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 3][6] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][6] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `rotate 90 degrees right shouldn't do anything if there is a collision cell`() {
        /*
        Rotate I block 90 degrees left, move it to the left of the board and then
        near the Square Block, then try to rotate (it shouldn't do anything), the table should be:
        |0123456789|
        |----------|
        |          | 0
        |..........| ...
        |   i      | 15
        |   iss    | 16
        .   iss    | 17
        |   iss    | 18
        |    ss    | 19
        |----------|
         */
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        game.moveBlock(Direction.LEFT)
        for (i in 0 until 15)
            game.moveBlock(Direction.DOWN)
        // Rotation which shouldn't do anything
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square blocks
        expectedGrid[GAME_ROWS - 4][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 4][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 3][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 3][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.SQUARE_BLOCK, false)
        // i block
        expectedGrid[GAME_ROWS - 5][3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 4][3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 3][3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][3] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

}