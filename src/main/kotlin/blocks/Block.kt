package blocks

import movements.Direction
import movements.Position
import movements.Rotation

abstract class Block(private val TYPES: List<List<Position>>, private var initialPosition: Position) {

    private var currentTypeIBlockIndex = 0

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