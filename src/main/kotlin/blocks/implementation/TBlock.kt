package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

internal val tBlockPositions = listOf(
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2)),
    listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 1))
)

class TBlock(initialPosition: Position) : Block {

    private val logic = BlockLogic(tBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions()

    override fun rotate(degree: Rotation) = logic.rotate(degree)

    override fun move(direction: Direction) = logic.move(direction)

}
