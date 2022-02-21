package board

import board.exceptions.InvalidPositionException
import movements.Position
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BoardWritePositionTest : BoardTest() {

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