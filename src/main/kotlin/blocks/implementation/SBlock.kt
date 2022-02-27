package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class SBlock(private var position: Position) : Block {

    private val positions = listOf(Position(0, 1), Position(0, 2), Position(1, 0), Position(1, 1))

    override fun getNeededPositions(): Collection<Position> = positions.map { p ->
        Position(p.row + position.row, p.column + position.column)
    }

    override fun rotate(degree: Rotation) {
        TODO("Not yet implemented")
    }

    override fun move(direction: Direction) {
        position = position.move(direction)
    }

}
