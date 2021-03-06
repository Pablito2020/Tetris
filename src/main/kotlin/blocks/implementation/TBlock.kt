package blocks.implementation

import blocks.Block
import blocks.Orientation
import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation
import java.io.Serializable

internal val tBlockPositions = mapOf(
    Orientation.NORMAL to listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(1, 2)),
    Orientation.ROTATED_RIGHT to listOf(Position(0, 1), Position(1, 1), Position(1, 2), Position(2, 1)),
    Orientation.ROTATED_180 to listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(2, 1)),
    Orientation.ROTATED_LEFT to listOf(Position(0, 1), Position(1, 0), Position(1, 1), Position(2, 1))
)

data class TBlock(private val position: Position, private val orientation: Orientation = Orientation.NORMAL) : Block,
    Serializable {

    override fun getNeededPositions(): Collection<Position> = tBlockPositions[orientation]!!.add(position)

    override fun rotate(degree: Rotation) = TBlock(position, orientation.turn(degree))

    override fun move(direction: Direction) = TBlock(position.move(direction), orientation)

    override fun getCell() = Cell.T_BLOCK

}
