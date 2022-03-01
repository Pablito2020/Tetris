package blocks.ZBlock

import blocks.implementation.ZBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ZBlockTest {

    @Test
    fun `position 0,0 needed positions are (0,0), (0,1), (1,1), (1,2)`() {
        val zBlock = ZBlock(Position(0,0))
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 2)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (0,1), (0,2), (1,2), (1,3)`() {
        val zBlock = ZBlock(Position(0,1))
        assertEquals(
            listOf(Position(0, 1), Position(0, 2), Position(1, 2), Position(1, 3)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 1,0 needed positions are (1,0), (1,1), (2,1), (2,2)`() {
        val zBlock = ZBlock(Position(1,0))
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2)),
            zBlock.getNeededPositions()
        )
    }

}