package block_factory

import blocks.Block
import game.normal.GAME_COLUMNS

internal data class BlockWrapper(val block: Block, val type: BlockType)

internal const val INITIAL_ROW_BLOCK = 0
internal const val INITIAL_COLUMN_BLOCK = (GAME_COLUMNS / 2) - 2

abstract class TemplateBlockCreator : BlockCreator {

    private var block: BlockWrapper? = null

    override fun getBlock(): Block {
        createBlockIfNotInitialized()
        val result = block!!.block
        block = getNewBlock()
        return result
    }

    override fun getNextBlockType(): BlockType  {
        createBlockIfNotInitialized()
        return block!!.type
    }

    internal abstract fun getNewBlock(): BlockWrapper

    private fun createBlockIfNotInitialized() {
        if (block == null)
            block = getNewBlock()
    }

}