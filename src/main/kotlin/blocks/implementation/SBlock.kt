package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class SBlock(private val position: Position) : Block {

    override fun getNeededPositions(): Collection<Position> {
        return listOf(Position(position.row + 0, position.column + 1), Position(position.row + 0, position.column + 2), Position(position.row + 1, position.column + 0), Position(position.row + 1, position.column + 1))
    }

    override fun rotate(degree: Rotation) {
        TODO("Not yet implemented")
    }

    override fun move(direction: Direction) {
        TODO("Not yet implemented")
    }

}
