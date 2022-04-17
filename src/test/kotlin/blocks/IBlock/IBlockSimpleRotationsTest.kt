package blocks.IBlock

import movements.Rotation
import blocks.SimpleRotation
import blocks.implementation.IBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockSimpleRotationsTest : SimpleRotation {

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val iBlock = IBlock(Position(0, 1))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 3), Position(1, 3), Position(2, 3), Position(3, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val iBlock = IBlock(Position(1, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 2), Position(2, 2), Position(3, 2), Position(4, 2)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`() {
        val iBlock = IBlock(Position(0, 1))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`() {
        val iBlock = IBlock(Position(1, 0))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 1), Position(3, 1), Position(4, 1)),
            iBlock.getNeededPositions()
        )
    }


}