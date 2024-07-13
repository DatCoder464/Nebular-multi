package net.nebular.reg

import com.simibubi.create.AllCreativeModeTabs.TabInfo
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.nebular.Nebular
import java.util.function.Supplier

object NebularCreativeTabs {

    val BASE: TabInfo = register("base") {
        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.nebular.base"))
            .icon { NebularBlocks.HULL.asStack() }
            .displayItems { param, out ->
                out.accept(NebularBlocks.HULL.asStack())
            }
            .build()
    }

    fun register(name: String, supplier: Supplier<CreativeModeTab>): TabInfo {
        val id: ResourceLocation = Nebular.asResource(name)
        val key: ResourceKey<CreativeModeTab> = ResourceKey.create(Registries.CREATIVE_MODE_TAB, id)
        val tab: CreativeModeTab = supplier.get()
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab)
        return TabInfo(key, tab)
    }

    fun register() {}

}