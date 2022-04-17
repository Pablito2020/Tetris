package blocks.SquareBlock

import movements.Rotation
import blocks.implementation.SquareBlock
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SquareBlockRotationTest {

    lateinit var squareBlock: SquareBlock

    @BeforeEach
    fun setUp() {
        squareBlock = SquareBlock(Position(1, 1))
    }

    @Test
    fun `Rotation to Left doesn't change anything`() {
        squareBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(2, 1), Position(2, 2)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    fun `Rotation to Right doesn't change anything`() {
        squareBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(2, 1), Position(2, 2)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    fun `Double rotation to left doesn't change anything`() {
        squareBlock.rotate(Rotation.LEFT_90_DEGREE)
        squareBlock.rotate(Rotation.LEFT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(2, 1), Position(2, 2)),
            squareBlock.getNeededPositions()
        )
    }

    @Test
    fun `Double rotation to right doesn't change anything`() {
        squareBlock.rotate(Rotation.RIGHT_90_DEGREE)
        squareBlock.rotate(Rotation.RIGHT_90_DEGREE)
        assertEquals(
            listOf(Position(1, 1), Position(1, 2), Position(2, 1), Position(2, 2)),
            squareBlock.getNeededPositions()
        )
    }
}