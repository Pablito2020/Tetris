import block_factory.BlockCreator
import block_factory.BlockType
import block_factory.RandomBlockCreator
import game.Game
import game.GameCell
import game.ghost.GhostGame
import game.normal.NormalGame
import movements.Direction
import movements.Rotation
import score.Points
import score.ScoreCalculator
import score.SimpleScoreCalculator
import java.io.Serializable

class GameFacade(
    private val blockGenerator: BlockCreator = RandomBlockCreator(),
    scoreCalculator: ScoreCalculator = SimpleScoreCalculator(),
    ghost: Boolean = false
) : Serializable {

    private val game: Game
    private var started = false

    init {
        game = if (ghost) GhostGame(blockGenerator, scoreCalculator)
        else NormalGame(blockGenerator, scoreCalculator)
    }

    /**
     * Start the game
     */
    fun start() {
        if (!started) game.generateNextBlock().also { started = true }
        else throw IllegalAccessError("Game has already started")
    }

    /**
     * Move the current block to the left and update the grid if needed
     */
    fun left() = game.moveBlock(Direction.LEFT)

    /**
     * Move the current block to the right and update the grid if needed
     */
    fun right() = game.moveBlock(Direction.RIGHT)

    /**
     * Move the current block down and update the grid if needed
     */
    fun down() {
        checkIfHasToWrite()
        game.moveBlock(Direction.DOWN)
    }

    /**
     * Move the current block down and update the grid if needed
     */
    fun rotateLeft() = game.rotateBlock(Rotation.LEFT_90_DEGREE)

    /**
     * Rotate the current block 90 degrees to the right, and update the grid if needed
     */
    fun rotateRight() = game.rotateBlock(Rotation.RIGHT_90_DEGREE)

    /**
     * Gets the current game grid
     * @return the current game grid
     * @see GameCell
     */
    fun getGrid(): List<List<GameCell>> = game.getGrid()

    /**
     * Returns the type of the next block that will be generated
     * @return the type of the next block that will be generated
     * @see BlockType
     */
    fun getNextBlock(): BlockType = blockGenerator.getNextBlockType()

    /**
     * Returns the current score of the game
     * @return the score of the game
     * @see Points
     */
    fun getScore() = game.getScore()

    /**
     * Returns whether the game is over or not
     * @return if the game is over or not
     */
    fun hasFinished() = game.hasFinished()

    /**
     * Drop the current block down the grid
     */
    fun dropBlock() {
        while (game.blockCanMoveDownNext())
            game.moveBlock(Direction.DOWN)
        writeBlock()
    }


    private fun checkIfHasToWrite() {
        if (!game.blockCanMoveDownNext())
            writeBlock()
    }

    private fun writeBlock() {
        game.writeBlockToBoard()
        game.generateNextBlock()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as GameFacade
        if (game != other.game) return false
        if (started != other.started) return false
        return true
    }

    override fun hashCode(): Int {
        var result = game.hashCode()
        result = 31 * result + started.hashCode()
        return result
    }

}