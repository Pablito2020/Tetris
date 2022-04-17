package blocks.JBlock

import blocks.DoubleRotationTest
import movements.Rotation
import blocks.implementation.JBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JBlockDoubleRotationTest : DoubleRotationTest {

    private lateinit var jBlock: JBlock

    @BeforeEach
    fun setUp() {
        jBlock = JBlock(Position(0, 0))
    }

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(1, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(1, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 2)),
            jBlock.getNeededPositions()
        )
    }

}