class IBlock(val position: Position) {

    fun getNeededPositions(): List<Position> {
        return listOf(Position(0, this.position.y), Position(0, this.position.y + 1), Position(0, this.position.y + 2), Position(0, this.position.y + 3))
    }

}
