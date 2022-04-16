package block_factory

import blocks.Block

interface BlockCreator {
    fun getBlock(): Block
}