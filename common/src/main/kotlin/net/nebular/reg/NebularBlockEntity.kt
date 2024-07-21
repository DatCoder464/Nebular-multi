package net.nebular.reg

import com.tterrag.registrate.util.entry.BlockEntityEntry
import net.nebular.Nebular.REGISTRATE
import net.nebular.content.block.entity.NozzleBlockEntity


object NebularBlockEntity {

    val NOZZLE: BlockEntityEntry<NozzleBlockEntity> = REGISTRATE
        .blockEntity(
            "nozzle",
            ::NozzleBlockEntity)
        .validBlock { NebularBlocks.NOZZLE.get() }
        .register()

    fun register() {

    }

}