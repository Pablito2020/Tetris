package game

import block_factory.BlockCreator
import blocks.implementation.IBlock
import blocks.implementation.SquareBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.invocation.Invocation
import org.mockito.invocation.InvocationOnMock
import score.Points
import score.ScoreCalculator


class ScoreTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        // Block Creator
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenAnswer {
            val invocations: Collection<Invocation> = Mockito.mockingDetails(blockCreator).invocations
            if (invocations.size % 3 == 1)
                SquareBlock(Position(0, (GAME_COLUMNS / 2) - 2))
            else
                IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        }
        // Score Calculator
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        Mockito.doAnswer { invocation: InvocationOnMock ->
            val consumer: Int = invocation.getArgument(0)
            Points(consumer)
        }.`when`(scoreCalculator).getScore(Mockito.anyInt())
        // Game
        game = Game(blockCreator, scoreCalculator)
        game.getNextBlock()
    }

    @Test
    fun `initial game has score of 0`() {
        assertEquals(game.getScore(), Points(0))
    }

    @Test
    fun `line should have a score of 1`() {
        getCompletedLines(lines = 1)
        assertEquals(Points(1), game.getScore())
    }

    @Test
    fun `two lines should have a score of 2`() {
        getCompletedLines(lines = 2)
        assertEquals(Points(2), game.getScore())
    }

    @Test
    fun `three lines should have a score of 3`() {
        getCompletedLines(lines = 3)
        assertEquals(Points(3), game.getScore())
    }

    @Test
    fun `four lines should have a score of 4`() {
        getCompletedLines(lines = 4)
        assertEquals(Points(4), game.getScore())
    }

    private fun getCompletedLines(lines: Int) {
        for (i in 0 until lines)
            getOneLine()
    }

    private fun getOneLine() {
        // square block
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.RIGHT)
        for (i in 0 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        // first I block
        game.getNextBlock()
        for (i in 0 until GAME_COLUMNS)
            game.moveBlock(Direction.LEFT)
        for (i in 0 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        // second I block
        game.getNextBlock()
        game.moveBlock(Direction.RIGHT)
        for (i in 0 until GAME_ROWS)
            game.moveBlock(Direction.DOWN)
        game.writeBlockToBoard()
        game.getNextBlock()
    }
}
