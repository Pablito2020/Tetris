class IBlock(val position: Position) {

    fun getNeededPositions(): Collection<Position> {
        val result = ArrayList<Position>()
        for (i in 0..3)
            result.add(Position(0, this.position.y + i))
        return result
    }

}
