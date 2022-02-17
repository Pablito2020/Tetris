package blocks

import movements.*

class IBlock(private var initialPosition: Position) {

    private var currentTypeIBlockIndex = 0

    private val TYPES = listOf(
        listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
        listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
        listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
        listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
    )

    fun getNeededPositions(): Collection<Position> {
        val result = ArrayList<Position>()
        for (currentPosition in TYPES[currentTypeIBlockIndex])
            result.add(Position(currentPosition.x + initialPosition.x, currentPosition.y + initialPosition.y))
        return result
    }

    fun rotate(degree: Rotation) {
        currentTypeIBlockIndex = when (degree) {
            Rotation.RIGHT_90_DEGREE -> (currentTypeIBlockIndex + 1) % TYPES.size
            Rotation.LEFT_90_DEGREE -> {
                if (currentTypeIBlockIndex == 0) TYPES.size - 1 else currentTypeIBlockIndex - 1
            }
        }
    }

    fun move(direction: Direction) {
        val x = when (direction) {
            Direction.LEFT -> -1
            Direction.RIGHT -> 1
        }
        initialPosition = Position(initialPosition.x, initialPosition.y + x)
    }

}
