package blocks.ZBlock

import blocks.deserialize
import blocks.implementation.ZBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ZBlockSerializeTest {

    private lateinit var block: ZBlock

    @BeforeEach
    fun setUp() {
        block = ZBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as ZBlock
        assertEquals(block, deserialized)
    }

}