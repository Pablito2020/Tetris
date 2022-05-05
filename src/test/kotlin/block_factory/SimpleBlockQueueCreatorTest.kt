package blocks.block_factory

import block_factory.SimpleBlockQueueCreator
import blocks.implementation.*
import game.normal.GAME_COLUMNS
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SimpleBlockQueueCreatorTest {

    private lateinit var queue: SimpleBlockQueueCreator
    private val initialBlockPositions = Position(0, (GAME_COLUMNS / 2) - 2)

    @BeforeEach
    fun setUp() {
        queue = SimpleBlockQueueCreator()
    }

    @Test
    fun `first get block returns i block`() {
        assertEquals(IBlock(initialBlockPositions), queue.getBlock())
    }

    @Test
    fun `second get block returns j block`() {
        queue.getBlock()
        assertEquals(JBlock(initialBlockPositions), queue.getBlock())
    }

    @Test
    fun `third get block returns l block`() {
        queue.getBlock()
        queue.getBlock()
        assertEquals(LBlock(initialBlockPositions), queue.getBlock())
    }

    @Test
    fun `fourth get block returns square block`() {
        queue.getBlock()
        queue.getBlock()
        queue.getBlock()
        assertEquals(SquareBlock(initialBlockPositions), queue.getBlock())
    }

    @Test
    fun `fifth get block returns t block`() {
        queue.getBlock()
        queue.getBlock()
        queue.getBlock()
        queue.getBlock()
        assertEquals(TBlock(initialBlockPositions), queue.getBlock())
    }

    @Test
    fun `second iteration block isn't the same reference`() {
        val firstBlock = queue.getBlock()
        (1 until 5).forEach { queue.getBlock() }
        val firstBlockSecondIteration = queue.getBlock()
        assertFalse(firstBlock === firstBlockSecondIteration)
        assertTrue(firstBlock == firstBlockSecondIteration)
    }

}