package net.nebular.reg

import com.tterrag.registrate.util.entry.BlockEntityEntry
import com.tterrag.registrate.util.nullness.NonNullFunction
import net.nebular.Nebular.REGISTRATE
import net.nebular.content.block.entity.NozzleBlockEntity
import net.nebular.content.block.entity.renderer.NozzleBlockEntityRenderer


object NebularBlockEntity {

    val NOZZLE: BlockEntityEntry<NozzleBlockEntity> = REGISTRATE
        .blockEntity(
            "nozzle",
            ::NozzleBlockEntity)
        .renderer { NonNullFunction { NozzleBlockEntityRenderer() } }
        .validBlock { NebularBlocks.NOZZLE.get() }
        .register()

    fun register() {

    }

}