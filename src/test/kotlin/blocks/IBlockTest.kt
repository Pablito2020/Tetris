package blocks

import movements.Position
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockTest {

    @Test
    fun `position 0,0 needed positions are (1,0), (1,1), (1,2), (1,3)`() {
        val iBlock = IBlock(Position(0, 0))
        assertEquals(
            listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (1,1), (1,2), (1,3), (1,4)`() {
        val iBlock = IBlock(Position(0, 1))
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(1, 3), Position(1, 4)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 1,0 needed positions are (2,0), (2,1), (2,2), (2,3)`() {
        val iBlock = IBlock(Position(1, 0))
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            iBlock.getNeededPositions()
        )
    }

}