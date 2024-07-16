package net.nebular.reg

import com.simibubi.create.content.decoration.encasing.CasingBlock
import com.simibubi.create.foundation.data.BuilderTransformers
import com.tterrag.registrate.util.entry.BlockEntry
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import net.nebular.Nebular
import net.nebular.content.block.NozzleBlock

object NebularBlocks {
    private val REGISTRATE = Nebular.REGISTRATE

    lateinit var HULL: BlockEntry<CasingBlock>
    lateinit var NOZZLE: BlockEntry<NozzleBlock>

    @JvmStatic
    fun register() {
        HULL = REGISTRATE.block("hull", ::CasingBlock)
            .properties { p -> p.mapColor(MapColor.METAL)}
            .transform( BuilderTransformers.casing { NebularSpriteShifts.HULL } )
            .register()

        NOZZLE = REGISTRATE.block("nozzle", ::NozzleBlock)
            .properties { p -> p.mapColor(MapColor.COLOR_CYAN) }
            .register()
    }
}