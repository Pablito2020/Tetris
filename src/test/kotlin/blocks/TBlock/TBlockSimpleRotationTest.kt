package blocks.TBlock

import movements.Rotation
import blocks.SimpleRotationTest
import blocks.implementation.TBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TBlockSimpleRotationTest : SimpleRotationTest {

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val tBlock = TBlock(Position(0, 0))
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 1)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val tBlock = TBlock(Position(0, 1))
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(1, 3), Position(2, 2)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val tBlock = TBlock(Position(1, 0))
        tBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 1), Position(2, 2), Position(3, 1)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val tBlock = TBlock(Position(0, 0))
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 1)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`() {
        val tBlock = TBlock(Position(0, 1))
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 1), Position(1, 2), Position(2, 2)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`() {
        val tBlock = TBlock(Position(1, 0))
        tBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(2, 0), Position(2, 1), Position(3, 1)),
            tBlock.getNeededPositions()
        )
    }

}