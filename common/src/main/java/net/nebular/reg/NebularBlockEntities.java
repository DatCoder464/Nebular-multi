package net.nebular.reg;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.nebular.content.block.nozzle.entity.NozzleBlockEntity;
import net.nebular.content.block.nozzle.entity.NozzleBlockEntityRenderer;

import static net.nebular.Nebular.REGISTRATE;

public class NebularBlockEntities {

    public static final BlockEntityEntry<NozzleBlockEntity> NOZZLE = REGISTRATE
        .blockEntity("nozzle", NozzleBlockEntity::new)
        .renderer(() -> NozzleBlockEntityRenderer::new)
        .validBlock(NebularBlocks.NOZZLE.lazy())
        .register();

    public static void register() {};

}