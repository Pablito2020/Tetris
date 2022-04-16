package blocks.implementation

import blocks.Block
import blocks.Rotation
import board.Cell
import movements.Direction
import movements.Position

internal val squareBlockPosition = listOf(
    Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
)

class SquareBlock(initialPosition: Position) : Block {

    private val logic = BlockLogic(listOf(squareBlockPosition), initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions()

    override fun rotate(degree: Rotation) {}

    override fun move(direction: Direction) = logic.move(direction)
    override fun getCell() = Cell.SQUARE_BLOCK

}
