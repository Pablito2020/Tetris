package blocks.SBlock

import blocks.deserialize
import blocks.implementation.SBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SBlockSerializeTest {

    private lateinit var block: SBlock

    @BeforeEach
    fun setUp() {
        block = SBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as SBlock
        assertEquals(block, deserialized)
    }

}