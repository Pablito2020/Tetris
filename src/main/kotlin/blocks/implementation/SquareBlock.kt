package blocks.implementation

import blocks.Block
import blocks.Orientation
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val squareBlockPosition = listOf(
    Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
)

class SquareBlock(private val position: Position, private val orientation: Orientation = Orientation.NORMAL) : Block {

    override fun getNeededPositions(): Collection<Position> = squareBlockPosition.add(position)

    override fun rotate(degree: Rotation) = SquareBlock(position)

    override fun move(direction: Direction) = SquareBlock(position.move(direction), orientation)

    override fun getCell() = Cell.SQUARE_BLOCK

}
