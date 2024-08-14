package net.nebular.content.block.nozzle.entity;

import com.mojang.blaze3d.vertex.*;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class NozzleBlockEntityRenderer extends SmartBlockEntityRenderer<NozzleBlockEntity> {

    public NozzleBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    //LoadedModel loaded = Format.INSTANCE.getOBJ().loadFrom(loadFile("nozzle.obj")).load(this::loadFile);

    @Override
    protected void renderSafe(NozzleBlockEntity nozzle, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                              int light, int overlay) {

    }
}
