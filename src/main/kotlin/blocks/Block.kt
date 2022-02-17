package blocks

import movements.Direction
import movements.Position
import movements.Rotation

abstract class Block(private val FORMATS_OF_BLOCK: List<List<Position>>, private var initialPosition: Position) {

    private var currentFormatIndex = 0

    fun getNeededPositions(): Collection<Position> {
        val currentBlockFormat = FORMATS_OF_BLOCK[currentFormatIndex]
        return currentBlockFormat.stream()
            .map { position -> position.addAxes(initialPosition) }
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
        initialPosition = initialPosition.move(direction)
    }

}