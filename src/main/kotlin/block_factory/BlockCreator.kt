package block_factory

import blocks.Block

interface BlockCreator {

    /**
     * Returns a new block, that you could already know the type of (thanks to the getNextBlockType() method)
     * Now, the result of getNextBlockType() will be different, so you should call getNextBlockType() again
     * @return the new instance of the block
     * @see Block
     */
    fun getBlock(): Block

    /**
     * Returns the next type of block that you can get with the second call to getBlock()
     * @return The next type of cell of the next block
     * @see getBlock
     */
    fun getNextBlockType(): BlockType
}