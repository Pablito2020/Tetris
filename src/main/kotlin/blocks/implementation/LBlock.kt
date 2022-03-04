package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class LBlock(private var initialPosition: Position): Block {

    var positions = listOf(Position(0, 0), Position(1, 0), Position(2, 0), Position(2,1))
    val rightPositions = listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(2,2))
    val leftPositions = listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(2,1))

    override fun getNeededPositions(): Collection<Position> {
        return positions.map({pos -> pos.addAxes(initialPosition)})
    }

    override fun rotate(degree: Rotation) {
        positions = when(degree) {
            Rotation.RIGHT_90_DEGREE -> rightPositions
            Rotation.LEFT_90_DEGREE -> leftPositions
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
