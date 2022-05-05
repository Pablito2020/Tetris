package block_factory

import blocks.Block
import movements.Direction
import java.util.*

abstract class TemplateQueueCreator: TemplateBlockCreator() {

    override fun getNewBlock(): BlockWrapper {
        val queue = getQueue()
        val element = queue.poll()
        val block = element.block.getNewInstance()
        queue.add(BlockWrapper(block, element.type))
        return element
    }

    internal abstract fun getQueue(): Queue<BlockWrapper>

    private fun Block.getNewInstance(): Block {
        val newBlock = this.move(Direction.RIGHT)
        return newBlock.move(Direction.LEFT)
    }
}