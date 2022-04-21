package blocks.SBlock

import blocks.Block
import blocks.MoveTest
import blocks.implementation.SBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SBlockMoveTest : MoveTest {

    lateinit var sBlock: Block

    @BeforeEach
    fun setUp() {
        sBlock = SBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        sBlock = sBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 4), Position(2, 5), Position(3, 3), Position(3, 4)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        sBlock = sBlock.move(Direction.RIGHT)
        sBlock = sBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 5), Position(2, 6), Position(3, 4), Position(3, 5)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        sBlock = sBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 2), Position(2, 3), Position(3, 1), Position(3, 2)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        sBlock = sBlock.move(Direction.LEFT)
        sBlock = sBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 1), Position(2, 2), Position(3, 0), Position(3, 1)),
            sBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row plus one`() {
        sBlock = sBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 3), Position(3, 4), Position(4, 2), Position(4, 3)),
            sBlock.getNeededPositions()
        )
    }

    override fun `Double move Down changes row plus two`() {
        sBlock = sBlock.move(Direction.DOWN)
        sBlock = sBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 3), Position(4, 4), Position(5, 2), Position(5, 3)),
            sBlock.getNeededPositions()
        )
    }
}