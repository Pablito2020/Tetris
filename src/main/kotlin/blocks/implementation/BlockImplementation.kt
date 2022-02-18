package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

abstract class BlockImplementation(private val FORMATS_OF_BLOCK: List<List<Position>>, private var initialPosition: Position):
    Block {

    private var currentFormatIndex = 0

    override fun getNeededPositions(): Collection<Position> {
        val currentBlockFormat = FORMATS_OF_BLOCK[currentFormatIndex]
        return currentBlockFormat.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        currentFormatIndex = when (degree) {
            Rotation.RIGHT_90_DEGREE -> (currentFormatIndex + 1) % FORMATS_OF_BLOCK.size
            Rotation.LEFT_90_DEGREE -> {
                if (currentFormatIndex == 0) FORMATS_OF_BLOCK.size - 1 else currentFormatIndex - 1
            }
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}