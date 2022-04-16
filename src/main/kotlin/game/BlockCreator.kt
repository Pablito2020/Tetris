package game

import blocks.Block

interface BlockCreator {
    fun getBlock(): Block
}