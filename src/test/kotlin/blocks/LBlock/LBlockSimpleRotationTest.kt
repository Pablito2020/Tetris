package blocks.LBlock

import movements.Rotation
import blocks.SimpleRotation
import blocks.implementation.LBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LBlockSimpleRotationTest : SimpleRotation {

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val lBlock = LBlock(Position(0, 0))
        lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(2, 2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val lBlock = LBlock(Position(0, 1))
        lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(2, 3)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val lBlock = LBlock(Position(1, 0))
        lBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 1), Position(3, 1), Position(3, 2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val lBlock = LBlock(Position(0, 0))
        lBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(2, 1)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`() {
        val lBlock = LBlock(Position(0, 1))
        lBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(0, 2), Position(1, 2), Position(2, 2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`() {
        val lBlock = LBlock(Position(1, 0))
        lBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(3, 1)),
            lBlock.getNeededPositions()
        )
    }
}