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
        this.IBlock = IBlock(Position(1, 1))
    }

    @Test
    fun `Move to Right changes position plus one`() {
        IBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    fun `Move to Left changes position plus one`() {
        IBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 2), Position(2, 3), Position(2, 4), Position(2, 5)),
            IBlock.getNeededPositions()
        )

    }

}