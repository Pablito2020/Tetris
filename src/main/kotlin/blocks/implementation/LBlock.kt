package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class LBlock(private val initialPosition: Position): Block {

    val positions = listOf(Position(0, 0), Position(1, 0), Position(2, 0), Position(2,1))

    override fun getNeededPositions(): Collection<Position> {
        return positions.map({pos -> pos.addAxes(initialPosition)})
    }

    override fun rotate(degree: Rotation) {
        TODO("Not yet implemented")
    }

    override fun move(direction: Direction) {
        TODO("Not yet implemented")
    }

}
