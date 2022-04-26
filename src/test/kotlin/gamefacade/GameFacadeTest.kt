package blocks.gamefacade

import GameFacade
import block_factory.BlockCreator
import blocks.implementation.IBlock
import game.normal.GAME_COLUMNS
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito
import score.ScoreCalculator
import kotlin.test.assertFailsWith

class GameFacadeTest {

    private lateinit var gameFacade: GameFacade

    @BeforeEach
    fun setUp() {
        val blockCreator = Mockito.mock(BlockCreator::class.java)
        Mockito.`when`(blockCreator.getBlock()).thenReturn(IBlock(Position(0, (GAME_COLUMNS / 2) - 2)))
        val scoreCalculator = Mockito.mock(ScoreCalculator::class.java)
        gameFacade = GameFacade(blockCreator, scoreCalculator)
    }

    @Test
    fun `uninitialized game doesn't throw exception when initialized`() {
        assertDoesNotThrow { gameFacade.start() }
    }

    @Test
    fun `initialized game throws IllegalAccessError when initialized`() {
        gameFacade.start()
        assertFailsWith<IllegalAccessError> { gameFacade.start() }
    }

}