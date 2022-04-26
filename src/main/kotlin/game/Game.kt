package game

import movements.Direction
import movements.Rotation
import score.Points

internal interface Game {

    fun getGrid(): List<List<GameCell>>

    fun generateNextBlock()

    fun moveBlock(direction: Direction)

    fun rotateBlock(rotation: Rotation)

    fun blockCanMoveDownNext(): Boolean

    fun writeBlockToBoard()

    fun hasFinished(): Boolean

    fun getScore(): Points

}