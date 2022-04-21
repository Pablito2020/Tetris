package blocks.JBlock

import blocks.MoveTest
import blocks.implementation.JBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JBlockMoveTest : MoveTest {

    private lateinit var jBlock: JBlock

    @BeforeEach
    fun setUp() {
        jBlock = JBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        jBlock = jBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 3), Position(3, 3), Position(3, 4), Position(3, 5)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        jBlock = jBlock.move(Direction.RIGHT)
        jBlock = jBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 4), Position(3, 4), Position(3, 5), Position(3, 6)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        jBlock = jBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 1), Position(3, 1), Position(3, 2), Position(3, 3)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        jBlock = jBlock.move(Direction.LEFT)
        jBlock = jBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 0), Position(3, 0), Position(3, 1), Position(3, 2)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row plus one`() {
        jBlock = jBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 2), Position(4, 2), Position(4, 3), Position(4, 4)),
            jBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row plus two`() {
        jBlock = jBlock.move(Direction.DOWN)
        jBlock = jBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 2), Position(5, 2), Position(5, 3), Position(5, 4)),
            jBlock.getNeededPositions()
        )
    }

}