package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

internal val iBlockPositions = listOf(
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
    listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
    listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
    listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
)

class IBlock(initialPosition: Position) : Block {

    private val blockImplementation = BlockLogic(iBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = blockImplementation.getNeededPositions()

    override fun rotate(degree: Rotation) = blockImplementation.rotate(degree)

    override fun move(direction: Direction) = blockImplementation.move(direction)

}