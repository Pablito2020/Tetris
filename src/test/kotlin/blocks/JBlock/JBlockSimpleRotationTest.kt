package blocks.JBlock

import blocks.Rotation
import blocks.SimpleRotation
import blocks.implementation.JBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JBlockSimpleRotationTest : SimpleRotation {

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val jBlock = JBlock(Position(0, 0))
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(0, 2), Position(1, 1), Position(2, 1)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val jBlock = JBlock(Position(0, 1))
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(0, 3), Position(1, 2), Position(2, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val jBlock = JBlock(Position(1, 0))
        jBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(2, 1), Position(3, 1)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val jBlock = JBlock(Position(0, 0))
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(2, 0), Position(2, 1)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`() {
        val jBlock = JBlock(Position(0, 1))
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(2, 1), Position(2, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`() {
        val jBlock = JBlock(Position(1, 0))
        jBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 1), Position(3, 0), Position(3, 1)),
            jBlock.getNeededPositions()
        )
    }

}