package net.nebular.content.block.entity.renderer

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.resources.ResourceLocation
import net.nebular.Nebular.MOD_ID
import net.nebular.content.block.entity.NozzleBlockEntity

class NozzleBlockEntityRenderer: ObjBlockEntityRenderer<NozzleBlockEntity>(ResourceLocation(MOD_ID, "nozzle")) {
    override fun afterRender(
        blockEntity: NozzleBlockEntity,
        partialTick: Float,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {
        super.afterRender(blockEntity, partialTick, poseStack, buffer, packedLight, packedOverlay)
    }
}