package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

internal val positions = listOf(
    Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
)

class SquareBlock(initialPosition: Position) : Block {

    private val logic = BlockLogic(listOf(positions), initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions()

    override fun rotate(degree: Rotation) {}

    override fun move(direction: Direction) = logic.move(direction)

}
