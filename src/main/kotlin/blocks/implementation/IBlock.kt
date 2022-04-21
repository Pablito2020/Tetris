package blocks.implementation

import blocks.Block
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val iBlockPositions = listOf(
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
    listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
    listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
    listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
)

class IBlock(private val initialPosition: Position, private val initialBlock: Int = 0) : Block {

    private val blockImplementation = BlockLogic(iBlockPositions, initialPosition)

    override fun getNeededPositions(): Collection<Position> = blockImplementation.getNeededPositions(initialBlock)

    override fun rotate(degree: Rotation) = IBlock(initialPosition, blockImplementation.rotate(degree, initialBlock))

    override fun move(direction: Direction) = IBlock(initialPosition.move(direction), initialBlock)

    override fun getCell(): Cell = Cell.I_BLOCK

}