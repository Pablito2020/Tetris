package blocks.LBlock

import blocks.Block
import blocks.DoubleRotationTest
import movements.Rotation
import blocks.implementation.LBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LBlockDoubleRotationTest : DoubleRotationTest {

    private lateinit var lBlock: Block

    @BeforeEach
    fun setUp() {
        lBlock = LBlock(Position(0, 0))
    }

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        lBlock = lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        lBlock = lBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 0), Position(1, 1), Position(1, 2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        lBlock = lBlock.rotate(Rotation.LEFT_90_DEGREE)
        lBlock = lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 0), Position(1, 1), Position(1, 2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        lBlock = lBlock.rotate(Rotation.LEFT_90_DEGREE)
        lBlock = lBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 0)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        lBlock = lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        lBlock = lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 0)),
            lBlock.getNeededPositions()
        )
    }

}