package board

import board.exceptions.InvalidPositionException
import board.exceptions.InvalidRowException
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardTest {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board(20, 10)
    }

    // isInside

    @Test
    fun `Out of bounds negative row position isn't inside board`() {
        assertFalse(board.isInside(Position(-1, 2)))
    }

    @Test
    fun `Out of bounds negative column position isn't inside board`() {
        assertFalse(board.isInside(Position(2, -1)))
    }

    @Test
    fun `Zero row position is inside board`() {
        assertTrue(board.isInside(Position(0, 2)))
    }

    @Test
    fun `Zero column position is inside board`() {
        assertTrue(board.isInside(Position(2, 0)))
    }

    @Test
    fun `Out of bounds positive column position isn't inside board`() {
        assertFalse(board.isInside(Position(2, 10)))
    }

    @Test
    fun `Out of bounds positive row position isn't inside board`() {
        assertFalse(board.isInside(Position(20, 2)))
    }

    @Test
    fun `Correct position is inside board`() {
        assertTrue(board.isInside(Position(2, 2)))
    }

    // isEmpty

    @Test
    fun `Accessing invalid position on empty throws invalid position exception`() {
        assertThrows<InvalidPositionException> { board.isEmpty(Position(-1, 2)) }
    }

    @Test
    fun `Accessing valid position that is empty returns true`() {
        assertTrue(board.isEmpty(Position(2, 2)))
    }

    @Test
    fun `Accessing held position by a I Block returns false`() {
        board.writePosition(Cell.I_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a S Block returns false`() {
        board.writePosition(Cell.S_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a Z Block returns false`() {
        board.writePosition(Cell.Z_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a L Block returns false`() {
        board.writePosition(Cell.L_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a J Block returns false`() {
        board.writePosition(Cell.J_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a Square Block returns false`() {
        board.writePosition(Cell.SQUARE_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    @Test
    fun `Accessing held position by a T Block returns false`() {
        board.writePosition(Cell.T_BLOCK, Position(0, 0))
        assertFalse(board.isEmpty(Position(0, 0)))
    }

    // isFull

    @Test
    fun `Accessing invalid negative throws InvalidRowException`() {
        assertThrows<InvalidRowException> { board.isFull(-1) }
    }

    @Test
    fun `Accessing invalid outside row throws InvalidRowException`() {
        assertThrows<InvalidRowException> { board.isFull(20) }
    }

    @Test
    fun `Accessing not full board returns false`() {
        assertFalse(board.isFull(0))
    }

    @Test
    fun `Accessing full board returns true`() {
        for (column in 0 until 10)
            board.writePosition(Cell.I_BLOCK, Position(0, column))
        assertTrue(board.isFull(0))
    }

    // TODO: writePosition(Cell, position), clear(row)

    @Test
    fun `Writing on invalid negative column throws InvalidPositionException`() {
        assertThrows<InvalidPositionException> { board.writePosition(Cell.I_BLOCK, Position(0, -1)) }
    }

    @Test
    fun `Writing on invalid negative row throws InvalidPositionException`() {
        assertThrows<InvalidPositionException> { board.writePosition(Cell.I_BLOCK, Position(-1, 0)) }
    }

    @Test
    fun `Writing on invalid positive column throws InvalidPositionException`() {
        assertThrows<InvalidPositionException> { board.writePosition(Cell.I_BLOCK, Position(2, 10)) }
    }

    @Test
    fun `Writing on invalid positive row throws InvalidPositionException`() {
        assertThrows<InvalidPositionException> { board.writePosition(Cell.I_BLOCK, Position(20, 2)) }
    }

    @Test
    fun `Writing on valid position changes the type of cell`() {
        board.writePosition(Cell.I_BLOCK, Position(2, 2))
        assertEquals(Cell.I_BLOCK, board.board[2][2])
    }

    @Test
    fun `Writing after a write makes the last write the current cell value`() {
        board.writePosition(Cell.I_BLOCK, Position(2, 2))
        board.writePosition(Cell.Z_BLOCK, Position(2, 2))
        assertEquals(Cell.Z_BLOCK, board.board[2][2])
    }

}