package blocks.SquareBlock

import blocks.MoveTest
import blocks.implementation.SquareBlock
import movements.Direction
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SquareBlockMoveTest : MoveTest {

    private lateinit var squareBlock: SquareBlock

    @BeforeEach
    fun setUp() {
        squareBlock = SquareBlock(Position(2, 2))
    }

    @Test
    override fun `Move to Right changes column plus one`() {
        squareBlock = squareBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 3), Position(2, 4), Position(3, 3), Position(3, 4)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Right changes column plus two`() {
        squareBlock = squareBlock.move(Direction.RIGHT)
        squareBlock = squareBlock.move(Direction.RIGHT)
        assertEquals(
            listOf(Position(2, 4), Position(2, 5), Position(3, 4), Position(3, 5)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move to Left changes column minus one`() {
        squareBlock = squareBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 1), Position(2, 2), Position(3, 1), Position(3, 2)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move to Left changes column minus two`() {
        squareBlock = squareBlock.move(Direction.LEFT)
        squareBlock = squareBlock.move(Direction.LEFT)
        assertEquals(
            listOf(Position(2, 0), Position(2, 1), Position(3, 0), Position(3, 1)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Move down changes row plus one`() {
        squareBlock = squareBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(3, 2), Position(3, 3), Position(4, 2), Position(4, 3)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    override fun `Double move Down changes row plus two`() {
        squareBlock = squareBlock.move(Direction.DOWN)
        squareBlock = squareBlock.move(Direction.DOWN)
        assertEquals(
            listOf(Position(4, 2), Position(4, 3), Position(5, 2), Position(5, 3)),
            squareBlock.getNeededPositions()
        )
    }
}