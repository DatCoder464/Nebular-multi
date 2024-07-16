package net.nebular.reg

import com.tterrag.registrate.util.entry.BlockEntityEntry
import net.nebular.Nebular.REGISTRATE
import net.nebular.content.block.entity.NozzleBlockEntity


object NebularBlockEntity {

    val NOZZLE: BlockEntityEntry<NozzleBlockEntity> = REGISTRATE
        .objBlockEntity(
            "nozzle",
            ::NozzleBlockEntity,
            { NebularBlocks.NOZZLE.get() })

}