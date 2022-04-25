package blocks.gamefacade

import GameFacade
import block_factory.BlockCreator
import block_factory.BlockType
import blocks.Block
import blocks.deserialize
import blocks.implementation.IBlock
import blocks.serialize
import game.normal.GAME_COLUMNS
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GameFacadeSerializableTest {

    private lateinit var gameFacade: GameFacade

    private class BlockCreatorSerialized : BlockCreator, java.io.Serializable {
        override fun getBlock(): Block = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        override fun getNextBlockType(): BlockType = throw UnsupportedOperationException("not implemented")
    }

    private class PointsSerialized : ScoreCalculator, java.io.Serializable {
        override fun getScore(cleanedRows: Int): Points = Points(0)
    }

    @BeforeEach
    fun setUp() {
        gameFacade = GameFacade(BlockCreatorSerialized(), PointsSerialized())
        gameFacade.start()
    }

    @Test
    fun `serialize provide same object`() {
        val bytes = serialize(gameFacade)
        val deserialized = deserialize(bytes) as GameFacade
        assertEquals(gameFacade, deserialized)
    }


    @Test
    fun `deserialize with changes doesn't provide same object as default`() {
        gameFacade.down()
        val bytes = serialize(gameFacade)
        val deserialized = deserialize(bytes) as GameFacade
        assertNotEquals(deserialized, GameFacade(BlockCreatorSerialized(), PointsSerialized()))
    }

    @Test
    fun `deserialize with changes provide the same changed object`() {
        gameFacade.down()
        gameFacade.left()
        val bytes = serialize(gameFacade)
        val deserialized = deserialize(bytes) as GameFacade
        val newGameFacade = GameFacade(BlockCreatorSerialized(), PointsSerialized())
        newGameFacade.start()
        newGameFacade.down()
        newGameFacade.left()
        assertEquals(deserialized, newGameFacade)
    }

}