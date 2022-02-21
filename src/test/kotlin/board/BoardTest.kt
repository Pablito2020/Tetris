package board

import org.junit.jupiter.api.BeforeEach

abstract class BoardTest {

    protected lateinit var board: Board

    @BeforeEach
    fun setUp() {
        board = Board(20, 10)
    }

}