package blocks.TBlock

import blocks.deserialize
import blocks.implementation.TBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TBlockSerializeTest {

    private lateinit var block: TBlock

    @BeforeEach
    fun setUp() {
        block = TBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as TBlock
        assertEquals(block, deserialized)
    }

}