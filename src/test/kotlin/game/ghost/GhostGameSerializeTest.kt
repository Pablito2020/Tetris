package blocks.game.ghost

import block_factory.BlockCreator
import block_factory.BlockType
import blocks.Block
import blocks.deserialize
import blocks.implementation.IBlock
import blocks.serialize
import game.Game
import game.ghost.GhostGame
import game.normal.GAME_COLUMNS
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import score.Points
import score.ScoreCalculator
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class GhostGameSerializeTest {

    private lateinit var game: GhostGame

    private class BlockCreatorSerialized : BlockCreator, java.io.Serializable {
        override fun getBlock(): Block = IBlock(Position(0, (GAME_COLUMNS / 2) - 2))
        override fun getNextBlockType(): BlockType = throw UnsupportedOperationException("not implemented")
    }

    private class PointsSerialized : ScoreCalculator, java.io.Serializable {
        override fun getScore(cleanedRows: Int): Points = Points(0)
    }

    @BeforeEach
    fun setUp() {
        game = GhostGame(BlockCreatorSerialized(), PointsSerialized())
    }

    @Test
    fun `serialize provide same object`() {
        val bytes = serialize(game)
        val deserialized = deserialize(bytes) as Game
        assertEquals(game, deserialized)
    }


    @Test
    fun `deserialize with changes doesn't provide same object as default`() {
        game.generateNextBlock()
        val bytes = serialize(game)
        val deserialized = deserialize(bytes) as Game
        assertNotEquals(deserialized, GhostGame(BlockCreatorSerialized(), PointsSerialized()))
    }

    @Test
    fun `deserialize with changes provide the same changed object`() {
        game.generateNextBlock()
        game.moveBlock(Direction.DOWN)
        val bytes = serialize(game)
        val deserialized = deserialize(bytes) as Game
        val newGame = GhostGame(BlockCreatorSerialized(), PointsSerialized())
        newGame.generateNextBlock()
        newGame.moveBlock(Direction.DOWN)
        assertEquals(deserialized, newGame)
    }

}