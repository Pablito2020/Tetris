import block_factory.BlockCreator
import block_factory.BlockType
import block_factory.RandomBlockCreator
import game.Game
import game.GameCell
import game.normal.NormalGame
import movements.Direction
import movements.Rotation
import score.Points
import score.ScoreCalculator
import score.SimpleScoreCalculator

class GameFacade(
    private val blockGenerator: BlockCreator = RandomBlockCreator(),
    scoreCalculator: ScoreCalculator = SimpleScoreCalculator(),
    private val game: Game = NormalGame(blockGenerator, scoreCalculator)
) {
    private var started = false

    /**
     * Start the game
     */
    fun start() {
        if (!started)
            game.generateNextBlock().also { started = true }
        else
            throw IllegalAccessError("Game has already started")
    }

    /**
     * Move the current block to the left and update the grid if needed
     */
    fun left() {
        game.moveBlock(Direction.LEFT)
        checkIfHasToWrite()
    }

    /**
     * Move the current block to the right and update the grid if needed
     */
    fun right() {
        game.moveBlock(Direction.RIGHT)
        checkIfHasToWrite()
    }

    /**
     * Move the current block down and update the grid if needed
     */
    fun down() {
        game.moveBlock(Direction.DOWN)
        checkIfHasToWrite()
    }

    /**
     * Move the current block down and update the grid if needed
     */
    fun rotateLeft() {
        game.rotateBlock(Rotation.LEFT_90_DEGREE)
        checkIfHasToWrite()
    }

    /**
     * Rotate the current block 90 degrees to the right, and update the grid if needed
     */
    fun rotateRight() {
        game.rotateBlock(Rotation.RIGHT_90_DEGREE)
        checkIfHasToWrite()
    }

    /**
     * Gets the current game grid
     * @return the current game grid
     * @see GameCell
     */
    fun getGrid(): List<List<GameCell>> {
        return game.getGrid()
    }

    /**
     * Returns the type of the next block that will be generated
     * @return the type of the next block that will be generated
     * @see BlockType
     */
    fun getNextBlock(): BlockType {
        return blockGenerator.getNextBlockType()
    }

    /**
     * Returns the current score of the game
     * @return the score of the game
     * @see Points
     */
    fun getScore(): Points {
        return game.getScore()
    }

    /**
     * Returns whether the game is over or not
     * @return if the game is over or not
     */
    fun hasFinished(): Boolean {
        return game.hasFinished()
    }

    private fun checkIfHasToWrite() {
        if (!game.blockCanMoveDownNext()) {
            game.writeBlockToBoard()
            game.generateNextBlock()
        }
    }

}