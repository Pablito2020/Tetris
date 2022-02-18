package blocks

import org.junit.jupiter.api.Test

interface DoubleRotation {

    @Test
    fun `Rotate block 90 degrees to right and then to left stays on same position`()

    @Test
    fun `Rotate block 90 degrees to left and then to right stays on same position`()

    @Test
    fun `Rotate block 180 degrees to left`()

    @Test
    fun `Rotate block 180 degrees to right`()
}