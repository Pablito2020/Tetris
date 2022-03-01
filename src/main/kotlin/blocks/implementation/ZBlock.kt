package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class ZBlock(private var initialPosition: Position): Block {

    private var positions = listOf(Position(0,0), Position(0,1), Position(1,1), Position(1,2))
    private val rightPositions = listOf(Position(0, 2), Position(1, 1), Position(1, 2), Position(2, 1))
    private val leftPositions = listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 0))

    override fun getNeededPositions(): Collection<Position> {
        return positions.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        positions = when(degree)  {
            Rotation.LEFT_90_DEGREE -> leftPositions
            Rotation.RIGHT_90_DEGREE -> rightPositions
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
