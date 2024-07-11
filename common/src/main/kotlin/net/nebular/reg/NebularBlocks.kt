package net.nebular.reg

import com.tterrag.registrate.util.entry.BlockEntry
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import net.nebular.Nebular
import net.nebular.Nebular.REGISTRATE

object NebularBlocks {
    val REGISTRATE = Nebular.REGISTRATE

    @JvmField
    val HULL: BlockEntry<Block> = REGISTRATE.block<Block>("ship_hull", ::Block)
        .properties { p -> p.mapColor(MapColor.METAL)}
        .item()
        .build()
        .register()

    @JvmStatic
    fun register() {}
}