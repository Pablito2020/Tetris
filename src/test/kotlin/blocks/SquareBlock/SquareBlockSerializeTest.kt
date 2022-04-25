package blocks.SquareBlock

import blocks.deserialize
import blocks.implementation.SquareBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SquareBlockSerializeTest {

    private lateinit var block: SquareBlock

    @BeforeEach
    fun setUp() {
        block = SquareBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as SquareBlock
        assertEquals(block, deserialized)
    }

}