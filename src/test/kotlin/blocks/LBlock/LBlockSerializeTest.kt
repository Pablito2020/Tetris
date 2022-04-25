package blocks.LBlock

import blocks.deserialize
import blocks.implementation.LBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LBlockSerializeTest {

    private lateinit var block: LBlock

    @BeforeEach
    fun setUp() {
        block = LBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as LBlock
        assertEquals(block, deserialized)
    }

}