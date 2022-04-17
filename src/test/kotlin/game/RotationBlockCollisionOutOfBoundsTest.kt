package game

import block_factory.BlockCreator
import block_factory.BlockType
import movements.Rotation
import blocks.implementation.IBlock
import board.Cell
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator

class RotationBlockCollisionOutOfBoundsTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game(object : BlockCreator {
            override fun getBlock() = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
            override fun getNextBlockType(): BlockType = TODO("Not yet implemented")
        }, object : ScoreCalculator {
            override fun getScore(cleanedRows: Int) = Points(0)
        })
        game.getNextBlock()
    }

    @Test
    fun `allowed simple rotation 90 degrees left without collision`() {
        /*
        rotate I block 90 degrees to the left. Result should be:
        |0123456789|
        |----------|
        |    i     | 0
        |    i     | 1
        |    i     | 2
        |    i     | 3
        . ........ ....
        |          | 18
        |          | 19
        |----------|
        */
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[0][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[3][4] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `allowed simple rotation 90 degrees right `() {
        /*
        rotate I block 90 degrees to the right. Result should be:
        |0123456789|
        |----------|
        |     i    | 0
        |     i    | 1
        |     i    | 2
        |     i    | 3
        . ........ ....
        |          | 18
        |          | 19
        |----------|
        */
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[0][5] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][5] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][5] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[3][5] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `out of bounds rotation to right`() {
        /*
        Rotate the block 90 degrees to right. Move It to the right of the board, then we should have something like this:
        |0123456789|
        |----------|
        |         i| 0
        |         i| 1
        |         i| 2
        |         i| 3
        . ........ ....
        |          | 18
        |          | 19
        |----------|
        So if we try to rotate the block to the right, it should not be allowed (the board remains on the same state)
        */
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        for (i in 0..GAME_COLUMNS - 1)
            game.moveBlock(Direction.RIGHT)
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[0][9] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][9] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][9] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[3][9] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }


    @Test
    fun `out of bounds rotation to left`() {
        /*
        Rotate the block 90 degrees to left. Move It to the left of the board, then we should have something like this:
        |0123456789|
        |----------|
        |i         | 0
        |i         | 1
        |i         | 2
        |i         | 3
        . ........ ....
        |          | 18
        |          | 19
        |----------|
        So if we try to rotate the block to the left, it should not be allowed (the board remains on the same state)
        */
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        for (i in 0..GAME_COLUMNS - 1)
            game.moveBlock(Direction.LEFT)
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[0][0] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[1][0] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[2][0] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[3][0] = GameCell(Cell.I_BLOCK, true)
        assertEquals(expectedGrid, game.getGrid())
    }

    @Test
    fun `out of bounds rotation to down`() {
        /*
        Move the I block down the board, then we should have something like this:
        |0123456789|
        |----------|
        |          | 0
        |          | 1
        |          | 2
        |          | 3
        . ........ ....
        |          | 18
        |   iiii   | 19
        |----------|
        So if we try to rotate the block to the left or right it shouldn't be allowed (the board remains on the same state)
        */
        for (i in 0..GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        val expectedGrid = MutableList(GAME_ROWS) { MutableList(GAME_COLUMNS) { GameCell(Cell.EMPTY, false) } }
        // square block
        expectedGrid[GAME_ROWS - 1][3] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][4] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][5] = GameCell(Cell.I_BLOCK, true)
        expectedGrid[GAME_ROWS - 1][6] = GameCell(Cell.I_BLOCK, true)
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        assertEquals(expectedGrid, game.getGrid())
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        assertEquals(expectedGrid, game.getGrid())
    }

}