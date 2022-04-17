package blocks

enum class Rotation {
    RIGHT_90_DEGREE,
    LEFT_90_DEGREE;

    fun opposite() = when (this) {
        RIGHT_90_DEGREE -> LEFT_90_DEGREE
        LEFT_90_DEGREE -> RIGHT_90_DEGREE
    }

}
