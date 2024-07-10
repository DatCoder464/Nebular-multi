package net.nebular.fabric

import com.simibubi.create.foundation.data.CreateRegistrate
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor
import net.nebular.Nebular
import net.fabricmc.api.ModInitializer
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.nebular.Nebular.MOD_ID
import net.nebular.reg.NebularBlocks
import java.util.function.Supplier

class NebularFabric : ModInitializer {
    override fun onInitialize() {
        NebularBlocks.register()
        Nebular.REGISTRATE.register()
        Nebular.init()
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation(MOD_ID)),
            Nebular.createCreativeTab()
        )
    }
}