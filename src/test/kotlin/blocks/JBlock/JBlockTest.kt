package blocks.JBlock

import blocks.implementation.JBlock
import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JBlockTest {

    @Test
    fun `position 0,0 needed positions are (0,0), (1,0), (1,1), (1,2)`() {
        val jBlock = JBlock(Position(0, 0))
        assertEquals(listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(1, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (0,1), (1,1), (1,2), (1,3)`() {
        val jBlock = JBlock(Position(0, 1))
        assertEquals(listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(1, 3)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 1,0 needed positions are (1,0), (2,0), (2,1), (2,2)`() {
        val jBlock = JBlock(Position(1, 0))
        assertEquals(listOf(Position(1, 0), Position(2, 0), Position(2, 1), Position(2, 2)),
            jBlock.getNeededPositions()
        )
    }

}