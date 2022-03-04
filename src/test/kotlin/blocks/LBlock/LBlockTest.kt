package blocks.LBlock

import blocks.implementation.LBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LBlockTest {

    @Test
    fun `position 0,0 needed positions are (0,2), (1,0), (1,1), (1,2)`() {
        val lBlock = LBlock(Position(0, 0))
        assertEquals(listOf(Position(0, 2), Position(1, 0), Position(1, 1), Position(1,2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (0,3), (1,1), (1,2), (1,3)`() {
        val lBlock = LBlock(Position(0, 1))
        assertEquals(listOf(Position(0, 3), Position(1, 1), Position(1, 2), Position(1,3)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 1,0 needed positions are (1,2), (2,0), (2,1), (2,2)`() {
        val lBlock = LBlock(Position(1, 0))
        assertEquals(listOf(Position(1, 2), Position(2, 0), Position(2, 1), Position(2,2)),
            lBlock.getNeededPositions()
        )
    }

}