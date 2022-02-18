package board

import board.exceptions.InvalidPositionException
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoardTest {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board(20, 10)
    }

    @Test
    fun `Out of bounds negative row position isn't inside board`(){
        assertFalse(board.isInside(Position(-1, 2)))
    }

    @Test
    fun `Out of bounds negative column position isn't inside board`(){
        assertFalse(board.isInside(Position(2, -1)))
    }

    @Test
    fun `Zero row position is inside board`(){
        assertTrue(board.isInside(Position(0, 2)))
    }

    @Test
    fun `Zero column position is inside board`(){
        assertTrue(board.isInside(Position(2, 0)))
    }

    @Test
    fun `Out of bounds positive column position isn't inside board`(){
        assertFalse(board.isInside(Position(2, 10)))
    }

    @Test
    fun `Out of bounds positive row position isn't inside board`(){
        assertFalse(board.isInside(Position(20, 2)))
    }

    @Test
    fun `Correct position is inside board`(){
        assertTrue(board.isInside(Position(2, 2)))
    }

    @Test
    fun `Accessing invalid position on empty throws invalid position exception`() {
        assertThrows<InvalidPositionException> {board.isEmpty(Position(-1, 2))  }
    }

    @Test
    fun `Accessing valid position that is empty returns true`() {
        assertTrue(board.isEmpty(Position(0, 0)))
    }

}