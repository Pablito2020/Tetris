package blocks.SquareBlock

import blocks.implementation.SquareBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SquareBlockTest {

    @Test
    fun `position 0,0 needed positions are (0,0), (0,1), (1,0), (1,1)`() {
        val squareBlock = SquareBlock(Position(0,0))
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (0,2), (0,3), (1,1), (1,2)`() {
        val squareBlock = SquareBlock(Position(0,1))
        assertEquals(
            listOf(Position(0, 1), Position(0, 2), Position(1, 1), Position(1, 2)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 1,0 needed positions are (1,1), (1,2), (2,0), (2,1)`() {
        val squareBlock = SquareBlock(Position(1,0))
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(2, 0), Position(2, 1)),
            squareBlock.getNeededPositions()
        )
    }
}