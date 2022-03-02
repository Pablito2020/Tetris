package blocks.TBlock

import blocks.Block
import blocks.MoveTest
import blocks.implementation.TBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TBlockMoveTest : MoveTest {

    private lateinit var tBlock: Block

    @BeforeEach
    fun setUp() {
        tBlock = TBlock(Position(2, 2))
    }


    @Test
    override fun `Move to Right changes column plus one`() {
        tBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 4), Position(3, 3), Position(3, 4), Position(3, 5)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        tBlock.move(Direction.RIGHT)
        tBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 5), Position(3, 4), Position(3, 5), Position(3, 6)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        tBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 2), Position(3, 1), Position(3, 2), Position(3, 3)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        tBlock.move(Direction.LEFT)
        tBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 1), Position(3, 0), Position(3, 1), Position(3, 2)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row minus one`() {
        tBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 3), Position(4, 2), Position(4, 3), Position(4, 4)),
            tBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row minus two`() {
        tBlock.move(Direction.DOWN)
        tBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 3), Position(5, 2), Position(5, 3), Position(5, 4)),
            tBlock.getNeededPositions()
        )
    }
}