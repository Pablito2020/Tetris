package blocks.implementation

import blocks.Block
import blocks.Rotation
import movements.Direction
import movements.Position

class JBlock(private var initialPosition: Position) : Block {

    private val initialState = listOf(Position(0, 0), Position(1, 0), Position(1, 1), Position(1, 2))
    private val rightState = listOf(Position(0, 1), Position(0, 2), Position(1, 1), Position(2, 1))
    private val leftState = listOf(Position(0, 1), Position(1, 1), Position(2, 0), Position(2, 1))
    private var state = initialState

    override fun getNeededPositions(): Collection<Position> {
        return state.map { position -> position.addAxes(initialPosition) }
    }

    override fun rotate(degree: Rotation) {
        state = when(degree) {
            Rotation.RIGHT_90_DEGREE -> rightState
            Rotation.LEFT_90_DEGREE -> leftState
        }
    }

    override fun move(direction: Direction) {
        initialPosition = initialPosition.move(direction)
    }

}
