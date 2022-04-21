package blocks.implementation

import blocks.Block
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val squareBlockPosition = listOf(
    Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
)

class SquareBlock(private val initialPosition: Position, private val initialIndex: Int = 0) : Block {

    private val logic = BlockLogic(listOf(squareBlockPosition), initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions(initialIndex)

    override fun rotate(degree: Rotation) = SquareBlock(initialPosition)

    override fun move(direction: Direction) = SquareBlock(initialPosition.move(direction), initialIndex)

    override fun getCell() = Cell.SQUARE_BLOCK

}
