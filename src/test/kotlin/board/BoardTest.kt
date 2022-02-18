package board

import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
}