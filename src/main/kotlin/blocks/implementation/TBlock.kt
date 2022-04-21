package blocks.implementation

import blocks.Block
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val tBlockPositions = listOf(
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2)),
    listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 1))
)

class TBlock(private val initialPosition: Position, private val initialIndex: Int = 0) : Block {

    private val logic = BlockLogic(tBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = logic.getNeededPositions(initialIndex)

    override fun rotate(degree: Rotation) = TBlock(initialPosition, logic.rotate(degree, initialIndex))

    override fun move(direction: Direction) = TBlock(initialPosition.move(direction), initialIndex)

    override fun getCell() = Cell.T_BLOCK

}
