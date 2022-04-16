package blocks.implementation

import blocks.Block
import blocks.Rotation
import board.Cell
import movements.Direction
import movements.Position

internal val zBlockPositions: List<List<Position>> = listOf(
    listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 2)),
    listOf(Position(0, 2), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2)),
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 0))
)

class ZBlock(initialPosition: Position) : Block {

    private val blockLogic = BlockLogic(zBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = blockLogic.getNeededPositions()

    override fun rotate(degree: Rotation) = blockLogic.rotate(degree)

    override fun move(direction: Direction) = blockLogic.move(direction)
    override fun getCell() = Cell.Z_BLOCK

}
