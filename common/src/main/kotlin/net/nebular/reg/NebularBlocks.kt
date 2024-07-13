package net.nebular.reg

import com.tterrag.registrate.util.entry.BlockEntry
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import net.nebular.Nebular

object NebularBlocks {
    private val REGISTRATE = Nebular.REGISTRATE

    @JvmField
    val HULL: BlockEntry<Block> = REGISTRATE.block<Block>("hull", ::Block)
        .properties { p -> p.mapColor(MapColor.METAL)}
        .simpleItem()
        .register()

    @JvmStatic
    fun register() {}
}