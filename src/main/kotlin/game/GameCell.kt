package game

import board.Cell

data class GameCell(val cell: Cell, val isCurrentBlockCell: Boolean = false, val isGhostBlockCell: Boolean = false)