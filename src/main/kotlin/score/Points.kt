package score

import java.io.Serializable

data class Points(val value: Int): Serializable {
    fun add(points: Points) = Points(this.value + points.value)
}