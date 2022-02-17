class IBlock(val position: Position) {

    fun getNeededPositions(): Collection<Position> {
        val result = ArrayList<Position>()
        for (i in 0..3)
            result.add(Position(position.x, this.position.y + i))
        return result
    }

}
