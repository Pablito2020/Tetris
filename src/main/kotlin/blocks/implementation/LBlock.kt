package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class LBlock(private var initialPosition: Position): Block {

    val defaultPositions = listOf(Position(0, 2), Position(1, 0), Position(1, 1), Position(1,2))
    val rightPositions = listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(2,2))
    val leftPositions = listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(2,1))
    val middlePosition = listOf(Position(1, 0), Position(1, 1), Position(1,2), Position(2, 0))
    var currentPosition = defaultPositions

    override fun getNeededPositions(): Collection<Position> {
        return currentPosition.map({pos -> pos.addAxes(initialPosition)})
    }

    override fun rotate(degree: Rotation) {
        currentPosition = when(degree) {
            Rotation.RIGHT_90_DEGREE -> {
                if (currentPosition == leftPositions)
                    defaultPositions
                else if (currentPosition == rightPositions)
                    middlePosition
                else
                    rightPositions
            }
            Rotation.LEFT_90_DEGREE -> {
                if (currentPosition == rightPositions)
                    defaultPositions
                else if (currentPosition == leftPositions)
                    middlePosition
                else
                    leftPositions
            }
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
