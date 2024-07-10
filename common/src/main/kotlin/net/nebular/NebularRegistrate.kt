package net.nebular

import com.simibubi.create.foundation.data.CreateRegistrate
import com.tterrag.registrate.builders.BlockBuilder
import com.tterrag.registrate.util.nullness.NonNullFunction
import net.nebular.reg.NebularBlocks
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour

class NebularRegistrate(modid: String) : CreateRegistrate(modid) {
    val creativeTab = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 10).icon { ItemStack(NebularBlocks.EXAMPLE_BLOCK) }
    override fun <T : Block?, P : Any?> block(
        parent: P,
        factory: NonNullFunction<BlockBehaviour.Properties, T>
    ): BlockBuilder<T, P> {
        return super.block(parent, factory)
    }
}