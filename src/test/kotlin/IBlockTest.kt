import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockTest {

    // Trivial Positions

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

    // Rotate 90 degrees to Right

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (0,0)`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`() {
        val iBlock = IBlock(Position(0, 1))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 3), Position(1, 3), Position(2, 3), Position(3, 3)),
            iBlock.getNeededPositions()
        )
    }

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`() {
        val iBlock = IBlock(Position(1, 0))
        iBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 2), Position(2, 2), Position(3, 2), Position(4, 2)),
            iBlock.getNeededPositions()
        )
    }

    // Rotate 90 degrees to Left

    @Test
    fun `Rotate 90 Degrees to Left changes Position from 0,0`() {
        val iBlock = IBlock(Position(0, 0))
        iBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
            iBlock.getNeededPositions()
        )
    }

}