import Rotation.LEFT_90_DEGREE
import Rotation.RIGHT_90_DEGREE

class IBlock(private val initialPosition: Position) {

    private var current_type_iblock_index = 0

    private val IBLOCK_POSSIBLE_VALUES = listOf(
        listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
        listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
        listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
        listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
    )

    fun getNeededPositions(): Collection<Position> {
        val result = ArrayList<Position>()
        for (currentPosition in IBLOCK_POSSIBLE_VALUES[current_type_iblock_index])
            result.add(Position(currentPosition.x + initialPosition.x, currentPosition.y + initialPosition.y))
        return result
    }

    fun rotate(degree: Rotation) {
        current_type_iblock_index = when (degree) {
            RIGHT_90_DEGREE -> current_type_iblock_index + 1 % IBLOCK_POSSIBLE_VALUES.size
            LEFT_90_DEGREE -> {
                if (current_type_iblock_index == 0) IBLOCK_POSSIBLE_VALUES.size - 1 else current_type_iblock_index - 1
            }
        }
    }

}
