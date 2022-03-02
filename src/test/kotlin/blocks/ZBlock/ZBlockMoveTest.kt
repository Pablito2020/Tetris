package blocks.ZBlock

import blocks.Block
import blocks.MoveTest
import blocks.implementation.ZBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ZBlockMoveTest : MoveTest {

    private lateinit var zBlock: Block

    @BeforeEach
    fun setUp() {
        zBlock = ZBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        zBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 3), Position(2, 4), Position(3, 4), Position(3, 5)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        zBlock.move(Direction.RIGHT)
        zBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 4), Position(2, 5), Position(3, 5), Position(3, 6)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        zBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 1), Position(2, 2), Position(3, 2), Position(3, 3)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        zBlock.move(Direction.LEFT)
        zBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(3, 1), Position(3, 2)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row plus one`() {
        zBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 2), Position(3, 3), Position(4, 3), Position(4, 4)),
            zBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row plus two`() {
        zBlock.move(Direction.DOWN)
        zBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 2), Position(4, 3), Position(5, 3), Position(5, 4)),
            zBlock.getNeededPositions()
        )
    }

}