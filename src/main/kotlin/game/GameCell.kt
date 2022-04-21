@file:Suppress("unused", "unused")

package game

import board.Cell

data class GameCell(val cell: Cell, val isCurrentBlockCell: Boolean = false)