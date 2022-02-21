package board

import board.exceptions.InvalidRowException
import movements.Position
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardIsFullTest : BoardTest() {

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

}