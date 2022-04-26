package blocks.board

import blocks.deserialize
import blocks.serialize
import board.Board
import board.Cell
import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class BoardSerializeTest {

    private lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board(row = 20, column = 10)
    }

    @Test
    fun `serialize provide same object`() {
        val bytes = serialize(board)
        val deserialized = deserialize(bytes) as Board
        assertEquals(board, deserialized)
    }


    @Test
    fun `deserialize with changes doesn't provide same object as default`() {
        board.writePosition(Cell.I_BLOCK, Position(0, 0))
        val bytes = serialize(board)
        val deserialized = deserialize(bytes) as Board
        val newBoard = Board(row = 20, column = 10)
        assertNotEquals(deserialized, newBoard)
    }

    @Test
    fun `deserialize with changes provide the same changed object`() {
        board.writePosition(Cell.I_BLOCK, Position(0, 0))
        val bytes = serialize(board)
        val deserialized = deserialize(bytes) as Board
        val newBoard = Board(row = 20, column = 10)
        newBoard.writePosition(Cell.I_BLOCK, Position(0, 0))
        assertEquals(deserialized, newBoard)
    }

}