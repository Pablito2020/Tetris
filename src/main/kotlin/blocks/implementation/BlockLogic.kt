package blocks.implementation

import movements.Direction
import movements.Position
import movements.Rotation

internal class BlockLogic(
    private val FORMATS_OF_BLOCK: List<List<Position>>,
    private var initialPosition: Position
) {

    fun getNeededPositions(currentFormatIndex: Int): Collection<Position> {
        val currentBlockFormat = FORMATS_OF_BLOCK[currentFormatIndex]
        return currentBlockFormat.map { position -> position.addAxes(initialPosition) }
    }

    fun rotate(degree: Rotation, currentFormatIndex: Int) = when (degree) {
        Rotation.RIGHT_90_DEGREE -> (currentFormatIndex + 1) % FORMATS_OF_BLOCK.size
        Rotation.LEFT_90_DEGREE -> {
            if (currentFormatIndex == 0) FORMATS_OF_BLOCK.size - 1 else currentFormatIndex - 1
        }
    }

}