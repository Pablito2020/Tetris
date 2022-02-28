package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class SquareBlock(private var initialPosition: Position) : Block {

    private val positions = listOf(
        Position(0, 0), Position(0, 1), Position(1, 0), Position(1, 1)
    )

    override fun getNeededPositions(): Collection<Position> {
        return positions.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {}

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
