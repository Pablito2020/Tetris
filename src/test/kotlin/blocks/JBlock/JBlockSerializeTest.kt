package blocks.JBlock

import blocks.deserialize
import blocks.implementation.JBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JBlockSerializeTest {

    private lateinit var block: JBlock

    @BeforeEach
    fun setUp() {
        block = JBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as JBlock
        assertEquals(block, deserialized)
    }

}