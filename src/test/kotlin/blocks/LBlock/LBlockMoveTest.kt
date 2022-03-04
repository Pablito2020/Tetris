package blocks.LBlock

import blocks.Block
import blocks.MoveTest
import blocks.implementation.LBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LBlockMoveTest : MoveTest {

    private lateinit var lBlock: Block

    @BeforeEach
    fun setUp() {
        lBlock = LBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        lBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 5), Position(3, 3), Position(3, 4), Position(3,5)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        lBlock.move(Direction.RIGHT)
        lBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 6), Position(3, 4), Position(3, 5), Position(3,6)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        lBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 3), Position(3, 1), Position(3, 2), Position(3,3)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        lBlock.move(Direction.LEFT)
        lBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 2), Position(3, 0), Position(3, 1), Position(3,2)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row plus one`() {
        lBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 4), Position(4, 2), Position(4, 3), Position(4,4)),
            lBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row plus two`() {
        lBlock.move(Direction.DOWN)
        lBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 4), Position(5, 2), Position(5, 3), Position(5,4)),
            lBlock.getNeededPositions()
        )
    }
}