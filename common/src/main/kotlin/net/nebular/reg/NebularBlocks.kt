package net.nebular.reg

import com.simibubi.create.content.decoration.encasing.CasingBlock
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry
import com.simibubi.create.foundation.data.BuilderTransformers
import com.tterrag.registrate.util.entry.BlockEntry
import net.nebular.Nebular
import net.nebular.Nebular.LOGGER
import net.nebular.NebularRegistrate
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import net.nebular.Nebular.REGISTRATE

object NebularBlocks {

    val EXAMPLE_BLOCK: BlockEntry<Block> = REGISTRATE.block("example_block", ::Block).register()
    val HULL: BlockEntry<CasingBlock> = REGISTRATE.block("hull", ::CasingBlock)
        .properties { p -> p.mapColor(MapColor.METAL)}
        .transform(BuilderTransformers.casing { NebularSpriteShifts.HULL })
        .register()
    fun init() =
        LOGGER.info("Registering blocks for " + Nebular.NAME)
}