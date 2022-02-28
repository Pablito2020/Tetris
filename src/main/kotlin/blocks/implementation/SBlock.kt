package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class SBlock(private var position: Position) : Block {

    private val POSITIONS = listOf(
        listOf(Position(0, 1), Position(0, 2), Position(1, 0), Position(1, 1)),
        listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(2, 1)),
        listOf(Position(1, 1), Position(1, 2), Position(2, 0), Position(2, 1)),
        listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 2))
    )
    private var positionIndex = 0

    override fun getNeededPositions(): Collection<Position> = POSITIONS[positionIndex].map { p ->
        Position(p.row + position.row, p.column + position.column)
    }

    override fun rotate(degree: Rotation) {
        positionIndex = when (degree) {
            Rotation.RIGHT_90_DEGREE -> if (positionIndex - 1 < 0) POSITIONS.size - 1 else positionIndex - 1
            Rotation.LEFT_90_DEGREE -> (positionIndex + 1) % POSITIONS.size
        }
    }

    override fun move(direction: Direction) {
        position = position.move(direction)
    }

}
