package block_factory

import java.util.*

abstract class TemplateQueueCreator: TemplateBlockCreator() {

    override fun getNewBlock(): BlockWrapper {
        val queue = getQueue()
        val element = queue.poll()
        queue.add(element.copy())
        return element
    }

    internal abstract fun getQueue(): Queue<BlockWrapper>

}