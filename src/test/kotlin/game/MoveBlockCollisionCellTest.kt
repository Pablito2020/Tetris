package game

import block_factory.BlockCreator
import blocks.Block
import blocks.implementation.IBlock
import blocks.implementation.SquareBlock
import board.Cell
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator

class MoveBlockCollisionCellTest {

    private lateinit var game: Game

    // mock object: first call returns T Block, second call returns I Block
    private val blockCreatorMock = object : BlockCreator {
        var firstBlockAlreadyGiven = false
        override fun getBlock(): Block {
            if (!firstBlockAlreadyGiven) {
                firstBlockAlreadyGiven = true
                return SquareBlock(Position(0, (GAME_COLUMNS / 2) - 1))
            } else {
                return IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
            }
        }
    }

    @BeforeEach
    fun setUp() {
        game = Game(blockCreatorMock, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
        // generate, move square block down and save it to the board
        game.getNextBlock()
        for (i in 0 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        // generate I block next
        game.getNextBlock()
    }

    @Test
    fun `move block to right if it has a cell that isn't empty don't changes block position`() {
        /*
        Move I block to the right of the board, then move it down near the Square Block and then
        try to move it to the left as far as you can (it shouldn't move).
        We should have as a result this board:
        |0123456789|
        |----------|
        |          | 0
        |          | 1
        |          | 2
        . ......... ....
        |    ssiiii| 18
        |    ss    | 19
        |----------|
         */
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.RIGHT)
        for (i in 1 until GAME_ROWS - 2)
            game.moveBlock(Direction.DOWN)
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.LEFT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[GAME_ROWS - 2][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.SQUARE_BLOCK, false)
        // i block
        expectedGrid[GAME_ROWS - 2][GAME_COLUMNS - 4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][GAME_COLUMNS - 3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][GAME_COLUMNS - 2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][GAME_COLUMNS - 1] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `move block to left if it has a cell that isn't empty don't changes block position`() {
        /*
        Move I block to the left of the board, then move it down near the Square Block and then
        try to move it to the right as far as you can (it shouldn't move).
        We should have as a result this board:
        | 123456789|
        |----------|
        |          | 0
        |          | 1
        |          | 2
        . ......... ....
        |iiiiss    | 18
        |    ss    | 19
        |----------|
         */
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.LEFT)
        for (i in 1 until GAME_ROWS - 2)
            game.moveBlock(Direction.DOWN)
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.RIGHT)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[GAME_ROWS - 2][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.SQUARE_BLOCK, false)
        // i block
        expectedGrid[GAME_ROWS - 2][0] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][1] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][2] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 2][3] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `move block to down doesn't do anything if it has a cell that isn't empty`() {
        /*
        Move I block to the down of the board. It should end up before the Square Block.
        We should have as a result this board:
        |0123456789|
        |----------|
        |          | 0
        |          | 1
        |          | 2
        . ......... ....
        |   iiii   | 17
        |    ss    | 18
        |    ss    | 19
        |----------|
         */
        for (i in 0 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[GAME_ROWS - 2][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 2][5] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.SQUARE_BLOCK, false)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.SQUARE_BLOCK, false)
        // i block
        expectedGrid[GAME_ROWS - 3][3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 3][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 3][5] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 3][6] = GameCell(Cell.I_BLOCK, true)
        Assertions.assertEquals(expectedGrid, game.getGrid())
    }

}