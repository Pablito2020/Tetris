package blocks

import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

interface Block {

    fun getNeededPositions(): Collection<Position>

    fun rotate(degree: Rotation)

    fun move(direction: Direction)

    fun getCell(): Cell

}