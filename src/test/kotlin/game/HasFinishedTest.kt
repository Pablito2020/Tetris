package game

import block_factory.BlockCreator
import block_factory.BlockType
import blocks.implementation.IBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HasFinishedTest {

    private lateinit var game : Game

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
    fun `new game has not finished`() {
        assertFalse(game.hasFinished())
    }


    @Test
    fun `game that has 4 columns of I blocks from 0 to GAME_ROWS is over`() {
        for (i in 0 until GAME_ROWS) {
            for (j in 0 until GAME_ROWS)
                game.moveBlock(Direction.DOWN)
            game.writeBlockToBoard()
            game.getNextBlock()
        }
        assertTrue(game.hasFinished())
    }

    @Test
    fun `game that has every column with non empty cells except the first two rows isn't finished`() {
        for (i in 0 until GAME_ROWS - 2) {
            for (j in 0 until GAME_ROWS)
                game.moveBlock(Direction.DOWN)
            game.writeBlockToBoard()
            game.getNextBlock()
        }
        assertFalse(game.hasFinished())
    }

}