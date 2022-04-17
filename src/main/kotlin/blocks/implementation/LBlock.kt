package blocks.implementation

import blocks.Block
import movements.Rotation
import board.Cell
import movements.Direction
import movements.Position

internal val lBlockPositions = listOf(
    listOf(Position(0, 2), Position(1, 0), Position(1, 1), Position(1, 2)),
    listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(2, 2)),
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 0)),
    listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(2, 1))
)

class LBlock(initialPosition: Position) : Block {

    private val logic = BlockLogic(lBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions()

    override fun rotate(degree: Rotation) = logic.rotate(degree)

    override fun move(direction: Direction) = logic.move(direction)

    override fun getCell() = Cell.L_BLOCK

}
