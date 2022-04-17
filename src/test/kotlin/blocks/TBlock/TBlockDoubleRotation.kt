package blocks.TBlock

import blocks.Block
import blocks.DoubleRotation
import movements.Rotation
import blocks.implementation.TBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TBlockDoubleRotation : DoubleRotation {

    private lateinit var tBlock: Block

    @BeforeEach
    fun setUp() {
        tBlock = TBlock(Position(0, 0))
    }

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1)),
            tBlock.getNeededPositions()
        )
    }
}