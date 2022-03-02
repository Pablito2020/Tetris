package blocks

import org.junit.jupiter.api.Test

interface MoveTest {

    @Test
    fun `Move to Right changes column plus one`()

    @Test
    fun `Double move to Right changes column plus two`()

    @Test
    fun `Move to Left changes column minus one`()

    @Test
    fun `Double move to Left changes column minus two`()

    @Test
    fun `Move down changes row plus one`()

    @Test
    fun `Double move Down changes row plus two`()
}