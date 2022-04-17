package blocks.IBlock

import movements.Rotation
import blocks.DoubleRotation
import blocks.implementation.IBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockDoubleRotationsTest : DoubleRotation {

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            iBlock.getNeededPositions()
        )
    }
}
