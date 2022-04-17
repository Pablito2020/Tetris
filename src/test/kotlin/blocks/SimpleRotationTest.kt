package blocks

import org.junit.jupiter.api.Test

interface SimpleRotationTest {

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (0,0)`()

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (0, 1)`()

    @Test
    fun `Rotate block 90 degrees to right changed needed positions from (1, 0)`()

    @Test
    fun `Rotate 90 Degrees to Left changes Position from 0,0`()

    @Test
    fun `Rotate block 90 degrees to Left changed needed positions from (0, 1)`()

    @Test
    fun `Rotate block 90 degrees to Left changed needed positions from (1, 0)`()

}