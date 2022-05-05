package block_factory

import blocks.implementation.*
import movements.Position

class RandomBlockCreator : TemplateBlockCreator() {

    override fun getNewBlock() = when (val type = BlockType.values().random()) {
        BlockType.I_BLOCK -> BlockWrapper(IBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.J_BLOCK -> BlockWrapper(JBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.S_BLOCK -> BlockWrapper(SBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.Z_BLOCK -> BlockWrapper(ZBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.L_BLOCK -> BlockWrapper(LBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.SQUARE_BLOCK -> BlockWrapper(SquareBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
        BlockType.T_BLOCK -> BlockWrapper(TBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), type)
    }

}