package blocks.implementation

import blocks.Block
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val sBlockPositions = listOf(
    listOf(Position(0, 1), Position(0, 2), Position(1, 0), Position(1, 1)),
    listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 2)),
    listOf(Position(1, 1), Position(1, 2), Position(2, 0), Position(2, 1)),
    listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(2, 1))
)

class SBlock(position: Position) : Block {

    private val blockLogic = BlockLogic(sBlockPositions, position)

    override fun getNeededPositions(): Collection<Position> = blockLogic.getNeededPositions()

    override fun rotate(degree: Rotation) = blockLogic.rotate(degree)

    override fun move(direction: Direction) = blockLogic.move(direction)

    override fun getCell() = Cell.S_BLOCK

}
