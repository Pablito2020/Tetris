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
        assertEquals(Position(1,2), position.move(Direction.DOWN))
    }

    @Test
    fun `Apply LEFT direction`(){
        assertEquals(Position(0,1), position.move(Direction.LEFT))
    }

    @Test
    fun `Apply RIGHT direction`(){
        assertEquals(Position(2,1), position.move(Direction.RIGHT))
    }

}