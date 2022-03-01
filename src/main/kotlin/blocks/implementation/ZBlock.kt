package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class ZBlock(private var initialPosition: Position): Block {

    private val positions = listOf(Position(0,0), Position(0,1), Position(1,1), Position(1,2))
    private val rightPositions = listOf(Position(0, 2), Position(1, 1), Position(1, 2), Position(2, 1))
    private val leftPositions = listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 0))
    private val middlePosition = listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2))
    private var pos = positions

    override fun getNeededPositions(): Collection<Position> {
        return pos.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        pos = when(degree)  {
            Rotation.LEFT_90_DEGREE -> {
                if (pos == rightPositions)
                    positions
                else if (pos == leftPositions)
                    middlePosition
                else
                    leftPositions
            }
            Rotation.RIGHT_90_DEGREE -> {
                if (pos == leftPositions)
                    positions
                else if (pos == rightPositions)
                    middlePosition
                else
                    rightPositions
            }
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
