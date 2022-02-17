import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockTest {

    @Test
    fun `position 0,0 needed positions are (0,0), (0,1), (0,2), (0,3)`() {
        val iBlock: IBlock = IBlock(Position(0, 0))
        assertEquals(
            listOf(Position(0, 0), Position(0, 1), Position(0, 2), Position(0, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    fun `position 0,1 needed positions are (0,1), (0,2), (0,3), (0,4)`() {
        val iBlock: IBlock = IBlock(Position(0, 1))
        assertEquals(
            listOf(Position(0, 1), Position(0, 2), Position(0, 3), Position(0, 4)),
            iBlock.getNeededPositions()
        )
    }

}