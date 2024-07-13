package net.nebular.forge

import com.simibubi.create.foundation.data.CreateRegistrate
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.CreativeModeTab
import net.nebular.Nebular
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.nebular.Nebular.MOD_ID
import net.nebular.reg.NebularBlocks
import net.nebular.reg.NebularCreativeTabs

@Mod(MOD_ID)
class NebularForge {
    init {
        // registrate must be given the mod event bus on forge before registration
        val eventBus = FMLJavaModLoadingContext.get().modEventBus
        (Nebular.REGISTRATE as CreateRegistrate).registerEventListeners(eventBus)

        Nebular.init()
    }
}