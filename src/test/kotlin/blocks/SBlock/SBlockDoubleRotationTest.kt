package blocks.SBlock

import blocks.Block
import blocks.DoubleRotationTest
import movements.Rotation
import blocks.implementation.SBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SBlockDoubleRotationTest : DoubleRotationTest {

    lateinit var sBlock: Block

    @BeforeEach
    fun setUp() {
        sBlock = SBlock(Position(2, 2))
    }

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        sBlock = sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        sBlock = sBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 3), Position(2, 4), Position(3, 2), Position(3, 3)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        sBlock = sBlock.rotate(Rotation.LEFT_90_DEGREE)
        sBlock = sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 3), Position(2, 4), Position(3, 2), Position(3, 3)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        sBlock = sBlock.rotate(Rotation.LEFT_90_DEGREE)
        sBlock = sBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(3, 3), Position(3, 4), Position(4, 2), Position(4, 3)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        sBlock = sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        sBlock = sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(3, 3), Position(3, 4), Position(4, 2), Position(4, 3)),
            sBlock.getNeededPositions()
        )
    }

}