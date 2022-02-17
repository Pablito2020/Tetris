class IBlock(position: Position) {

    fun getNeededPositions(): List<Position> {
        return listOf(Position(0,0), Position(0, 1), Position(0, 2), Position(0, 3))
    }

}
