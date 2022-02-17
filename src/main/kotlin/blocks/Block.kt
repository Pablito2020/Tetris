package blocks

import movements.Direction
import movements.Position
import movements.Rotation

abstract class Block(private val FORMATS_OF_BLOCK: List<List<Position>>, private var initialPosition: Position) {

    private var currentFormatIndex = 0

    fun getNeededPositions(): Collection<Position> {
        val currentBlockFormat = FORMATS_OF_BLOCK[currentFormatIndex]
        return currentBlockFormat.stream()
            .map { position -> Position(position.x + initialPosition.x, position.y + initialPosition.y) }
            .toList()
    }

    fun rotate(degree: Rotation) {
        currentFormatIndex = when (degree) {
            Rotation.RIGHT_90_DEGREE -> (currentFormatIndex + 1) % FORMATS_OF_BLOCK.size
            Rotation.LEFT_90_DEGREE -> {
                if (currentFormatIndex == 0) FORMATS_OF_BLOCK.size - 1 else currentFormatIndex - 1
            }
        }
    }

    fun move(direction: Direction) {
        val x = when (direction) {
            Direction.LEFT -> -1
            Direction.RIGHT -> 1
            else -> 0
        }
        val y = if (direction == Direction.DOWN) 1 else 0
        initialPosition = Position(initialPosition.x + y, initialPosition.y + x)
    }

}