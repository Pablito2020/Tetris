package blocks

import movements.Position

class IBlock(initialPosition: Position) : Block(TYPES, initialPosition)

private val TYPES = listOf(
    listOf(Position(1, 0), Position(1, 1), Position(1, 2), Position(1, 3)),
    listOf(Position(0, 2), Position(1, 2), Position(2, 2), Position(3, 2)),
    listOf(Position(2, 0), Position(2, 1), Position(2, 2), Position(2, 3)),
    listOf(Position(0, 1), Position(1, 1), Position(2, 1), Position(3, 1)),
)

