package blocks.SBlock

import movements.Rotation
import blocks.SimpleRotation
import blocks.implementation.SBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SBlockSimpleRotationsTest : SimpleRotation {

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val sBlock = SBlock(Position(0, 0))
        sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 2)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val sBlock = SBlock(Position(0, 1))
        sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(1, 3), Position(2, 3)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val sBlock = SBlock(Position(1, 0))
        sBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 1), Position(2, 2), Position(3, 2)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val sBlock = SBlock(Position(0, 0))
        sBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(2, 1)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`() {
        val sBlock = SBlock(Position(0, 1))
        sBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 2)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`() {
        val sBlock = SBlock(Position(1, 0))
        sBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(2, 0), Position(2, 1), Position(3, 1)),
            sBlock.getNeededPositions()
        )
    }

}