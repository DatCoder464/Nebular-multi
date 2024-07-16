package net.nebular.foundation

import com.simibubi.create.foundation.data.CreateRegistrate
import com.tterrag.registrate.builders.BlockBuilder
import com.tterrag.registrate.builders.BlockEntityBuilder
import com.tterrag.registrate.util.entry.BlockEntityEntry
import com.tterrag.registrate.util.nullness.NonNullFunction
import com.tterrag.registrate.util.nullness.NonNullSupplier
import io.github.fabricators_of_create.porting_lib.PortingLibObjLoader
import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraft.world.level.block.state.BlockState
import net.nebular.Nebular.MOD_ID
import net.nebular.content.block.entity.renderer.ObjBlockEntityRenderer

class NebularRegistrate(modid: String?) : CreateRegistrate(modid) {

    fun <T : BlockEntity?> blockEntity(name: String, factory: (BlockPos, BlockState) -> T): BlockEntityBuilder<T, NebularRegistrate> {
        return this.blockEntity(name, factory)
    }

    fun <T : BlockEntity?> objBlockEntity(name: String, factory: (BlockPos, BlockState) -> T, vararg blocks: NonNullSupplier<Block>): BlockEntityEntry<T> {
        return this.blockEntity(name, factory)
            .renderer { NonNullFunction { ObjBlockEntityRenderer<T>(ResourceLocation(MOD_ID, "models/block/$name.obj")) } }
            .validBlocks(*blocks)
            .register()
    }

    fun <T: Block> block(name: String, factory: (Properties) -> T): BlockBuilder<T, CreateRegistrate> {
        return this.block<T>(name, factory)
    }
}