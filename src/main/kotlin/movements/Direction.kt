package movements

enum class Direction {
    LEFT,
    RIGHT,
    DOWN,
    UP;

    fun opposite() = when (this) {
        LEFT -> RIGHT
        RIGHT -> LEFT
        DOWN -> UP
        UP -> DOWN
    }

}