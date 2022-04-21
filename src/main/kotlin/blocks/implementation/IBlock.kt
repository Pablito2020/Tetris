package blocks.implementation

import blocks.Block
import blocks.Orientation
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

internal val iBlockPositions = mapOf(
    Orientation.NORMAL to listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
    Orientation.ROTATED_RIGHT to listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
    Orientation.ROTATED_180 to listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
    Orientation.ROTATED_LEFT to listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
)

class IBlock(private val position: Position, private val orientation: Orientation = Orientation.NORMAL) :
    Block {

    override fun getNeededPositions(): Collection<Position> = iBlockPositions[orientation]!!.add(position)

    override fun rotate(degree: Rotation) = IBlock(position, orientation.turn(degree))

    override fun move(direction: Direction) = IBlock(position.move(direction), orientation)

    override fun getCell(): Cell = Cell.I_BLOCK

}