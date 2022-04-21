package blocks

import board.Cell
import movements.Direction
import movements.Position
import movements.Rotation

interface Block {

    fun getNeededPositions(): Collection<Position>

    fun rotate(degree: Rotation): Block

    fun move(direction: Direction): Block

    fun getCell(): Cell

}