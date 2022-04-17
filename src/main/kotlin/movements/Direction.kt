package movements

enum class Direction: Opposite<Direction> {
    LEFT,
    RIGHT,
    DOWN,
    UP;

    override fun opposite() = when (this) {
        LEFT -> RIGHT
        RIGHT -> LEFT
        DOWN -> UP
        UP -> DOWN
    }

}