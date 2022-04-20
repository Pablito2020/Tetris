package game

import block_factory.BlockCreator
import blocks.implementation.IBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import score.ScoreCalculator
import kotlin.test.assertTrue

class GameMoveDownNextTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        game = Game(blockCreator, scoreCalculator)
        game.getNextBlock()
    }

    @Test
    fun `first move always can move down`() {
        assertTrue(game.blockCanMoveDownNext())
    }

    @Test
    fun `down the board less 1 can move down`() {
        for (i in 1 until GAME_ROWS - 2)
            game.moveBlock(Direction.DOWN)
        assertTrue(game.blockCanMoveDownNext())
    }

    @Test
    fun `down the board can't move more`() {
        for (i in 1 until GAME_ROWS - 1)
            game.moveBlock(Direction.DOWN)
        assertFalse(game.blockCanMoveDownNext())
    }

}