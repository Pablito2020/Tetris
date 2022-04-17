package movements

enum class Rotation : Opposite<Rotation> {
    RIGHT_90_DEGREE,
    LEFT_90_DEGREE;

    override fun opposite() = when (this) {
        RIGHT_90_DEGREE -> LEFT_90_DEGREE
        LEFT_90_DEGREE -> RIGHT_90_DEGREE
    }

}
