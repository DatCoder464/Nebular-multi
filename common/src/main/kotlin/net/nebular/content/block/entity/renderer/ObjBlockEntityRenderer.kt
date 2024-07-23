package net.nebular.content.block.entity.renderer

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.*
import com.mojang.blaze3d.vertex.VertexFormat.Mode
import me.alex_s168.meshlib.format.Format
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.entity.BlockEntity
import net.nebular.Nebular.MOD_ID
import java.io.File

open class ObjBlockEntityRenderer<T : BlockEntity?>(objFile: ResourceLocation): BlockEntityRenderer<T> {
    private fun loadFile(name: String): String =
        File(ResourceLocation(MOD_ID, "models/block/$name").path).readText()

    private val loaded = Format.OBJ.loadFrom(File(objFile.path).readText()).load(::loadFile).apply { this.verify() }

    private val model = loaded.groups.values.map { group ->
        val material = group.material?.let(loaded.materials::get)
        val texture = ResourceLocation(MOD_ID, "textures/block${material?.diffuseMapFile}")

        texture to group.mesh
    }

    override fun render(
        blockEntity: T,
        partialTick: Float,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {
        val pose = poseStack.last().pose()
        model.forEach { (texture, mesh) ->
            RenderSystem.setShader(GameRenderer::getPositionTexShader)

            RenderSystem.enableDepthTest()
            RenderSystem.enableBlend()
            RenderSystem.defaultBlendFunc()
            RenderSystem.enableCull()

            val builder: BufferBuilder = Tesselator.getInstance().builder
            RenderSystem._setShaderTexture(0, texture)
            builder.begin(Mode.TRIANGLES, DefaultVertexFormat.POSITION_TEX)

            mesh.forEach { (tri, pUv) ->
                val uv = pUv ?: throw IllegalArgumentException()

                builder.vertex(pose, tri.a.x, tri.a.y, tri.a.z)
                    .uv(1 - uv.a.u, 1 - uv.a.v)
                    .endVertex()

                builder.vertex(pose, tri.b.x, tri.b.y, tri.b.z)
                    .uv(1 - uv.b.u, 1 - uv.b.v)
                    .endVertex()

                builder.vertex(pose, tri.c.x, tri.c.y, tri.c.z)
                    .uv(1 - uv.c.u, 1 - uv.c.v)
                    .endVertex()
            }
            val built = builder.end()
            BufferUploader.drawWithShader(built)
        }
        afterRender(blockEntity, partialTick, poseStack, buffer, packedLight, packedOverlay)
    }

    open fun afterRender(
        blockEntity: T,
        partialTick: Float,
        poseStack: PoseStack,
        buffer: MultiBufferSource,
        packedLight: Int,
        packedOverlay: Int
    ) {

    }
}