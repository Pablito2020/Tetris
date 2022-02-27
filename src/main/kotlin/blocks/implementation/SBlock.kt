package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class SBlock(private var position: Position) : Block {

    private val positions = listOf(Position(0, 1), Position(0, 2), Position(1, 0), Position(1, 1))
    private val rightDegreePositions = listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 2))
    private val leftDegreePositions = listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(2, 1))
    private var currentPosition: List<Position> = positions

    override fun getNeededPositions(): Collection<Position> = currentPosition.map { p ->
        Position(p.row + position.row, p.column + position.column)
    }

    override fun rotate(degree: Rotation) {
        currentPosition = when(degree) {
            Rotation.RIGHT_90_DEGREE -> rightDegreePositions
            Rotation.LEFT_90_DEGREE -> leftDegreePositions
        }
    }

    override fun move(direction: Direction) {
        position = position.move(direction)
    }

}
