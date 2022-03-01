package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class ZBlock(private val initialPosition: Position): Block {

    private val positions = listOf(Position(0,0), Position(0,1), Position(1,1), Position(1,2))

    override fun getNeededPositions(): Collection<Position> {
        return positions.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        TODO("Not yet implemented")
    }

    override fun move(direction: Direction) {
        TODO("Not yet implemented")
    }

}
