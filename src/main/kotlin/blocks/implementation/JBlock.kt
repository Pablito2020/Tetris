package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class JBlock(private var initialPosition: Position) : Block {

    private val initialState = listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(1, 2))

    override fun getNeededPositions(): Collection<Position> {
        return initialState.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        TODO("Not yet implemented")
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
