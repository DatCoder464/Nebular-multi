package net.examplemod

import com.tterrag.registrate.util.entry.BlockEntry
import net.examplemod.ExampleMod.LOGGER
import net.examplemod.ExampleMod.REGISTRATE
import net.minecraft.world.level.block.Block

object ExampleBlocks {
    val EXAMPLE_BLOCK: BlockEntry<Block> = REGISTRATE.block<Block>("example_block", ::Block).register()

    fun init() =
        LOGGER.info("Registering blocks for " + ExampleMod.NAME)
}