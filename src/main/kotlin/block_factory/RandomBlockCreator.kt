package block_factory

import blocks.Block
import blocks.implementation.*
import game.normal.GAME_COLUMNS
import movements.Position

data class BlockWrapper(val block: Block, val type: BlockType)

internal const val INITIAL_ROW_BLOCK = 0
internal const val INITIAL_COLUMN_BLOCK = (GAME_COLUMNS / 2) - 2

class RandomBlockCreator : BlockCreator {

    private var actualBlock: BlockWrapper = getNewBlock()
    private var nextBlock: BlockWrapper = getNewBlock()

    override fun getBlock(): Block {
        val result = actualBlock.block
        actualBlock = nextBlock
        nextBlock = getNewBlock()
        return result
    }

    override fun getNextBlockType() = nextBlock.type

    private fun getNewBlock() = when (val type = BlockType.values().random()) {
        BlockType.I_BLOCK -> BlockWrapper(IBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.J_BLOCK -> BlockWrapper(JBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.S_BLOCK -> BlockWrapper(SBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.Z_BLOCK -> BlockWrapper(ZBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.L_BLOCK -> BlockWrapper(LBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.SQUARE_BLOCK -> BlockWrapper(SquareBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.T_BLOCK -> BlockWrapper(TBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
    }

}