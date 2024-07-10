package net.nebular

import com.simibubi.create.Create
import com.simibubi.create.foundation.data.CreateRegistrate
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.nebular.reg.NebularBlocks
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Nebular {
    const val MOD_ID = "nebular"
    const val NAME = "Nebular"

    @JvmStatic
    val LOGGER: Logger = LoggerFactory.getLogger(NAME)
    val REGISTRATE: CreateRegistrate = CreateRegistrate.create(MOD_ID)

    @JvmStatic
    fun init() {
        LOGGER.info(
            "{} initializing! on platform: {}",
            NAME,
            ExampleExpectPlatform.platformName()
        )
    }

    fun asResource(path: String): ResourceLocation =
        ResourceLocation(MOD_ID, path)

    fun createCreativeTab(): CreativeModeTab =
        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.nebular"))
            .icon { NebularBlocks.HULL.asStack() }
            .displayItems { _, output ->
                output.accept(NebularBlocks.HULL.asStack())
//                REGISTRATE.getAll(BuiltInRegistries.ITEM.key()).forEach {
//                    it as ItemEntry<*>
//                    output.accept(it.asStack())
//                }
//                REGISTRATE.getAll(BuiltInRegistries.BLOCK.key()).forEach {
//                    it as BlockEntry<*>
//                    output.accept(it.asStack())
//                }
            }
            .build()

}