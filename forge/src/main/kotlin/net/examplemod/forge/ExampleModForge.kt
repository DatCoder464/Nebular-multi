package net.examplemod.forge

import com.simibubi.create.foundation.data.CreateRegistrate
import net.examplemod.ExampleMod
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(ExampleMod.MOD_ID)
class ExampleModForge {
    init {
        // registrate must be given the mod event bus on forge before registration
        val eventBus = FMLJavaModLoadingContext.get().modEventBus
        (ExampleMod.REGISTRATE as CreateRegistrate).registerEventListeners(eventBus)
        ExampleMod.init()
    }
}