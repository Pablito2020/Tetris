package blocks

import blocks.interfaces.MoveTest
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IBlockMoveTest: MoveTest{

    private lateinit var IBlock: IBlock

    @BeforeEach
    fun setUp() {
        this.IBlock = IBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        IBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(3, 3), Position(3, 4), Position(3, 5), Position(3, 6)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        IBlock.move(Direction.RIGHT)
        IBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(3, 4), Position(3, 5), Position(3, 6), Position(3, 7)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        IBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(3, 1), Position(3, 2), Position(3, 3), Position(3, 4)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        IBlock.move(Direction.LEFT)
        IBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(3, 0), Position(3, 1), Position(3, 2), Position(3, 3)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row minus one`() {
        IBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 2), Position(4, 3), Position(4, 4), Position(4, 5)),
            IBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row minus two`() {
        IBlock.move(Direction.DOWN)
        IBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(5, 2), Position(5, 3), Position(5, 4), Position(5, 5)),
            IBlock.getNeededPositions()
        )
    }

}