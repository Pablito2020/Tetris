package movements

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PositionTest {

    lateinit var position: Position

    @BeforeEach
    fun setUp() {
        position = Position(1,1)
    }

    @Test
    fun `Apply DOWN direction`(){
        assertEquals(Position(2,1), position.move(Direction.DOWN))
    }

    @Test
    fun `Apply LEFT direction`(){
        assertEquals(Position(1,0), position.move(Direction.LEFT))
    }

    @Test
    fun `Apply RIGHT direction`(){
        assertEquals(Position(1,2), position.move(Direction.RIGHT))
    }

    @Test
    fun `Add axes with (0, 0) position`(){
        val other = Position(0, 0)
        assertEquals(Position(1, 1), position.addAxes(other))
    }

    @Test
    fun `Add axes with negative row position`(){
        val other = Position(-1, 0)
        assertEquals(Position(0, 1), position.addAxes(other))
    }

    @Test
    fun `Add axes with negative column position`(){
        val other = Position(0, -1)
        assertEquals(Position(1, 0), position.addAxes(other))
    }

    @Test
    fun `Simple positive add`(){
        val other = Position(1, 1)
        assertEquals(Position(2, 2), position.addAxes(other))
    }

}