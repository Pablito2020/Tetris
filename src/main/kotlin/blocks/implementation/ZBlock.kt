package blocks.implementation

import blocks.Block
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val zBlockPositions: List<List<Position>> = listOf(
    listOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 2)),
    listOf(Position(0, 2), Position(1, 1), Position(1, 2), Position(2, 1)),
    listOf(Position(1, 0), Position(1, 1), Position(2, 1), Position(2, 2)),
    listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 0))
)

class ZBlock(private val initialPosition: Position, private val initialIndex: Int = 0) : Block {

    private val blockLogic = BlockLogic(zBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = blockLogic.getNeededPositions(initialIndex)

    override fun rotate(degree: Rotation) = ZBlock(initialPosition, blockLogic.rotate(degree, initialIndex))

    override fun move(direction: Direction) = ZBlock(initialPosition.move(direction), initialIndex)

    override fun getCell() = Cell.Z_BLOCK

}
