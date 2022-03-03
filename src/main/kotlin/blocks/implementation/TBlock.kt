package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class TBlock(private var initialPosition: Position) : Block {

    val positions = listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2))
    val rightPositions = listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 1))
    val leftPositions = listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 1))
    val middlePositions = listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1))
    var currentPosition = positions

    override fun getNeededPositions(): Collection<Position> {
        return currentPosition.map({ pos -> pos.addAxes(initialPosition) })
    }

    override fun rotate(degree: Rotation) {
        currentPosition = when (degree) {
            Rotation.RIGHT_90_DEGREE -> {
                if (currentPosition == leftPositions)
                    positions
                else if (currentPosition == rightPositions)
                    middlePositions
                else
                    rightPositions
            }
            Rotation.LEFT_90_DEGREE -> {
                if (currentPosition == rightPositions)
                    positions
                else if (currentPosition == leftPositions)
                    middlePositions
                else
                    leftPositions
            }
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
