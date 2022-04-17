package score

data class Points(val value: Int) {
    fun add(points: Points) = Points(this.value + points.value)
}