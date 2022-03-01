package blocks.ZBlock

import blocks.Block
import blocks.DoubleRotation
import blocks.Rotation
import blocks.implementation.ZBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ZBlockDoubleRotation : DoubleRotation {

    private lateinit var zBlock: Block

    @BeforeEach
    fun setUp() {
        zBlock = ZBlock(Position(0, 0))
    }

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        zBlock.rotate(Rotation.RIGHT_90_DEGREE)
        zBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 2)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        zBlock.rotate(Rotation.LEFT_90_DEGREE)
        zBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 2)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        zBlock.rotate(Rotation.LEFT_90_DEGREE)
        zBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        zBlock.rotate(Rotation.RIGHT_90_DEGREE)
        zBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2)),
            zBlock.getNeededPositions()
        )
    }

}