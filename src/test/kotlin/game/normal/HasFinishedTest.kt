package game.normal

import block_factory.BlockCreator
import blocks.implementation.IBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HasFinishedTest {

    private lateinit var game: NormalGame

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenAnswer({
            IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        })
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        game = NormalGame(blockCreator, scoreCalculator)
        game.generateNextBlock()
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
            game.generateNextBlock()
        }
        assertTrue(game.hasFinished())
    }

    @Test
    fun `game that has every column with non empty cells except the first two rows isn't finished`() {
        for (i in 0 until GAME_ROWS - 2) {
            for (j in 0 until GAME_ROWS)
                game.moveBlock(Direction.DOWN)
            game.writeBlockToBoard()
            game.generateNextBlock()
        }
        assertFalse(game.hasFinished())
    }

}