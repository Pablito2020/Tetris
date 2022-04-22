package game.ghost

import board.Cell
import game.GameCell
import game.ghost.getLastEmptyBlock
import game.ghost.getRowOffset
import movements.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class UtilsTest {

    @Test
    fun `empty grid returns as position last row with same column`() {
        val position = Position(1, 1)
        val grid = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY) } }
        assertEquals(Position(19, 1), position.getLastEmptyBlock(grid))
    }

    @Test
    fun `if last row is full, previous row with same column`() {
        val position = Position(1, 1)
        val grid = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY) } }
        for (i in 0..9)
            grid[19][i] = GameCell(Cell.I_BLOCK)
        assertEquals(Position(18, 1), position.getLastEmptyBlock(grid))
    }

    @Test
    fun `if next block is current block, skip it`() {
        val position = Position(1, 1)
        val grid = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY) } }
        grid[2][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        assertEquals(Position(19, 1), position.getLastEmptyBlock(grid))
    }

    @Test
    fun `if next two blocks are current block, skip it`() {
        val position = Position(1, 1)
        val grid = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY) } }
        grid[2][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        grid[3][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        assertEquals(Position(19, 1), position.getLastEmptyBlock(grid))
    }

    @Test
    fun `base case of row offset`() {
        val positions = listOf(Position(1, 1), Position(2, 1), Position(3, 1), Position(4, 1))
        val grid = MutableList(20) { MutableList(10) { GameCell(Cell.EMPTY) } }
        grid[1][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        grid[2][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        grid[3][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        grid[4][1] = GameCell(Cell.I_BLOCK, isCurrentBlockCell = true)
        assertEquals(15, positions.getRowOffset(grid))
    }

}
