package board

import board.exceptions.InvalidRowException
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class BoardClearTest {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board(20, 10)
    }

    @Test
    fun `Clearing on invalid negative row throws InvalidRowException`() {
        assertThrows<InvalidRowException>({ board.clear(-1) })
    }

    @Test
    fun `Clearing on invalid positive row throws InvalidRowException`() {
        assertThrows<InvalidRowException>({ board.clear(20) })
    }

    @Test
    fun `Clearing an already empty row doesn't make anything`() {
        board.clear(2)
        assertEquals(List(10, { Cell.EMPTY }), board.board[2])
    }

    @Test
    fun `Clearing a non empty row clears the row`() {
        board.writePosition(Cell.I_BLOCK, Position(2, 1))
        board.writePosition(Cell.J_BLOCK, Position(2, 9))
        board.clear(2)
        assertEquals(List(10, { Cell.EMPTY }), board.board[2])
    }

}