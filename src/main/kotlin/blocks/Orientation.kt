package blocks

import movements.Rotation

enum class Orientation {
    NORMAL,
    ROTATED_RIGHT,
    ROTATED_LEFT,
    ROTATED_180;

    fun turn(rotation: Rotation) = when (rotation) {
        Rotation.LEFT_90_DEGREE -> turnLeft()
        Rotation.RIGHT_90_DEGREE -> turnRight()
    }

    private fun turnLeft() = when (this) {
        NORMAL -> ROTATED_LEFT
        ROTATED_RIGHT -> NORMAL
        ROTATED_LEFT -> ROTATED_180
        ROTATED_180 -> ROTATED_RIGHT
    }

    private fun turnRight() = when (this) {
        NORMAL -> ROTATED_RIGHT
        ROTATED_RIGHT -> ROTATED_180
        ROTATED_LEFT -> NORMAL
        ROTATED_180 -> ROTATED_LEFT
    }


}