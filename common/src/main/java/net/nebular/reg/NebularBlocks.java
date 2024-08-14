package net.nebular.reg;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.nebular.Nebular;
import net.nebular.content.block.nozzle.NozzleBlock;
import net.nebular.foundation.NebularRegistrate;

import java.util.Collection;

public class NebularBlocks {
    private static final NebularRegistrate REGISTRATE = Nebular.REGISTRATE;

    public static final BlockEntry<CasingBlock> HULL = REGISTRATE.block("hull", CasingBlock::new)
        .properties(p -> p.mapColor(MapColor.METAL))
        .transform( BuilderTransformers.casing( () -> NebularSpriteShifts.HULL ) )
        .item()
        .tab(NebularCreativeTabs.BASE.key)
        .build()
        .register();

    public static final BlockEntry<NozzleBlock> NOZZLE = REGISTRATE.block("nozzle", NozzleBlock::new)
        .properties( p -> p.mapColor(MapColor.COLOR_CYAN) )
        .item()
        .tab(NebularCreativeTabs.BASE.key)
        .build()
        .register();


    public static final Collection<RegistryEntry<Block>> ENTRIES = REGISTRATE.getAll(BuiltInRegistries.BLOCK.key());

    public static void register() {}
}