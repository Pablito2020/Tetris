package blocks

import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockMoveTest {

    private lateinit var IBlock: IBlock

    @BeforeEach
    fun setUp() {
        this.IBlock = IBlock(Position(2, 2))
    }

    @Test
    fun `Move to Right changes position plus one`() {
        IBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(3, 1), Position(3, 2), Position(3, 3), Position(3, 4)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    fun `Move to Left changes position plus one`() {
        IBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(3, 3), Position(3, 4), Position(3, 5), Position(3, 6)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    fun `Double move to Left changes position plus two`() {
        IBlock.move(Direction.LEFT)
        IBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(3, 0), Position(3, 1), Position(3, 2), Position(3, 3)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    fun `Double move to Right changes position plus two`() {
        IBlock.move(Direction.RIGHT)
        IBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(3, 4), Position(3, 5), Position(3, 6), Position(3, 7)),
            IBlock.getNeededPositions()
        )
    }

}