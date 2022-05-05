package block_factory

import blocks.implementation.*
import movements.Position
import java.util.*

class AllBlockQueueCreator : TemplateQueueCreator(){

    private val allBlockQueue: Queue<BlockWrapper> = LinkedList()

    init {
        allBlockQueue.addAll(
            listOf(
                BlockWrapper(IBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.I_BLOCK),
                BlockWrapper(JBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.J_BLOCK),
                BlockWrapper(SBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.S_BLOCK),
                BlockWrapper(ZBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.Z_BLOCK),
                BlockWrapper(LBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.L_BLOCK),
                BlockWrapper(SquareBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.SQUARE_BLOCK),
                BlockWrapper(TBlock(Position(INITIAL_ROW_BLOCK, INITIAL_COLUMN_BLOCK)), BlockType.T_BLOCK)
            )
        )
    }

    override fun getQueue(): Queue<BlockWrapper> = allBlockQueue

}