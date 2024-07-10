package net.nebular.reg

import com.simibubi.create.content.decoration.encasing.CasingBlock
import com.simibubi.create.foundation.data.BuilderTransformers
import com.tterrag.registrate.util.entry.BlockEntry
import net.minecraft.world.level.material.MapColor
import net.nebular.Nebular.REGISTRATE

@Suppress("unused")
object NebularBlocks {
    @JvmField
    val HULL: BlockEntry<CasingBlock> = REGISTRATE.block<CasingBlock>("ship_hull", ::CasingBlock)
        .properties { p -> p.mapColor(MapColor.METAL)}
        .transform(BuilderTransformers.casing { NebularSpriteShifts.HULL })
        .item()
        .build()
        .register()

    @JvmStatic
    fun register() {}
}