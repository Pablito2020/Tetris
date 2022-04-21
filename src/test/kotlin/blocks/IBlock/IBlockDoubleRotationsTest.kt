package blocks.IBlock

import movements.Rotation
import blocks.DoubleRotationTest
import blocks.implementation.IBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockDoubleRotationsTest : DoubleRotationTest {

    @Test
    override fun `Rotate block 90 degrees to right and then to left stays on same position`() {
        var iBlock = IBlock(Position(0, 0))
        iBlock = iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        iBlock = iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to left and then to right stays on same position`() {
        var iBlock = IBlock(Position(0, 0))
        iBlock = iBlock.rotate(Rotation.LEFT_90_DEGREE)
        iBlock = iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to left`() {
        var iBlock = IBlock(Position(0, 0))
        iBlock = iBlock.rotate(Rotation.LEFT_90_DEGREE)
        iBlock = iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 180 degrees to right`() {
        var iBlock = IBlock(Position(0, 0))
        iBlock = iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        iBlock = iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            iBlock.getNeededPositions()
        )
    }
}
