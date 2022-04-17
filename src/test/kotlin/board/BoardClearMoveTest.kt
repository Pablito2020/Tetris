package board

import movements.Position
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class BoardRedoWithClearedCells: BoardTest() {

    private val ROW = 20
    private val COLUMN = 10
    private lateinit var emptyResult: MutableList<MutableList<Cell>>

    @BeforeEach
    fun setUpEmptyResult() {
        super.setUp()
        emptyResult = MutableList(ROW) { MutableList(COLUMN) { Cell.EMPTY } }
    }

    @Test
    fun `clear when we don't have any completed line`() {
        writeNonFullRowOn(ROW - 1)
        board.redoBoardWithClearedCells()
        assertFalse(board.isClear(ROW - 1))
    }

    @Test
    fun `clear when we have one completed line at bottom`() {
        writeFullRowOn(ROW - 1)
        assertTrue(board.isFull(ROW - 1))
        board.redoBoardWithClearedCells()
        for (row in 0 until ROW)
            assertTrue(board.isClear(row))
    }

    @Test
    fun `clear when we have one completed line in the middle`() {
        writeNonFullRowOn(ROW - 1)
        writeFullRowOn(ROW - 2)
        writeNonFullRowOn(ROW - 3)
        assertTrue(board.isFull(ROW - 2))
        board.redoBoardWithClearedCells()
        assertTrue(board.isClear(ROW - 3))
        assertFalse(board.isClear(ROW - 2))
        assertFalse(board.isClear(ROW - 1))
    }

    @Test
    fun `clear when we have two completed lines`() {
        writeNonFullRowOn(ROW - 1)
        writeFullRowOn(ROW - 2)
        writeFullRowOn(ROW - 3)
        writeNonFullRowOn(ROW - 4)
        board.redoBoardWithClearedCells()
        assertTrue(board.isClear(ROW - 4))
        assertTrue(board.isClear(ROW - 3))
        assertFalse(board.isClear(ROW - 2))
        assertFalse(board.isClear(ROW - 1))
    }

    @Test
    fun `clear when we have three completed lines`() {
        writeNonFullRowOn(ROW - 1)
        writeFullRowOn(ROW - 2)
        writeFullRowOn(ROW - 3)
        writeFullRowOn(ROW - 4)
        writeNonFullRowOn(ROW - 5)
        board.redoBoardWithClearedCells()
        assertTrue(board.isClear(ROW - 5))
        assertTrue(board.isClear(ROW - 4))
        assertTrue(board.isClear(ROW - 3))
        assertFalse(board.isClear(ROW - 2))
        assertFalse(board.isClear(ROW - 1))
    }

    @Test
    fun `clear when we have four completed lines`() {
        writeNonFullRowOn(ROW - 1)
        writeFullRowOn(ROW - 2)
        writeFullRowOn(ROW - 3)
        writeFullRowOn(ROW - 4)
        writeFullRowOn(ROW - 5)
        writeNonFullRowOn(ROW - 6)
        board.redoBoardWithClearedCells()
        assertTrue(board.isClear(ROW - 6))
        assertTrue(board.isClear(ROW - 5))
        assertTrue(board.isClear(ROW - 4))
        assertTrue(board.isClear(ROW - 3))
        assertFalse(board.isClear(ROW - 2))
        assertFalse(board.isClear(ROW - 1))
    }

    // method helpers

    fun writeNonFullRowOn(row: Int) {
        (0 until COLUMN - 1).forEach{col -> board.writePosition(Cell.I_BLOCK, Position(row, col))}
    }

    fun writeFullRowOn(row: Int) {
        (0 until COLUMN).forEach{col -> board.writePosition(Cell.I_BLOCK, Position(row, col))}
    }

}