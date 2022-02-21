package board

import board.exceptions.InvalidPositionException
import movements.Position
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardIsEmptyTest : BoardTest() {

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

}