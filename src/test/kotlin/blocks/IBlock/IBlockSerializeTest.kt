package blocks.IBlock

import blocks.deserialize
import blocks.implementation.IBlock
import blocks.serialize
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockSerializeTest {

    private lateinit var block: IBlock

    @BeforeEach
    fun setUp() {
        block = IBlock(position = Position(0, 0))
    }

    @Test
    fun deserializeProvidesSameObject() {
        val bytes = serialize(block)
        val deserialized = deserialize(bytes) as IBlock
        assertEquals(block, deserialized)
    }

}