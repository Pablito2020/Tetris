package block_factory

import blocks.Block
import blocks.implementation.*
import game.GAME_COLUMNS
import movements.Position

data class BlockWrapper(val block: Block, val type: BlockType)

internal const val INITIAL_ROW_BLOCK = 0
internal const val INITIAL_COLUMN_BLOCK = (GAME_COLUMNS / 2) - 2

class RandomBlockCreator : BlockCreator {

    private var actualBlock: BlockWrapper = getNewBlock()
    private var nextBlock: BlockWrapper = getNewBlock()
    private val list = listOf(
        BlockWrapper(IBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.I_BLOCK),
        BlockWrapper(JBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.J_BLOCK),
        BlockWrapper(SBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.S_BLOCK),
        BlockWrapper(ZBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.Z_BLOCK),
        BlockWrapper(LBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.L_BLOCK),
        BlockWrapper(SquareBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.SQUARE_BLOCK),
        BlockWrapper(TBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.T_BLOCK),
    )

    override fun getBlock(): Block {
        val result = actualBlock.block
        actualBlock = nextBlock
        nextBlock = getNewBlock()
        return result
    }

    override fun getNextBlockType() = nextBlock.type

    private fun getNewBlock() = list.random()

}