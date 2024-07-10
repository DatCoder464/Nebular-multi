package net.nebular.forge

import com.simibubi.create.foundation.data.CreateRegistrate
import net.nebular.Nebular
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(Nebular.MOD_ID)
class NebularForge {
    init {
        // registrate must be given the mod event bus on forge before registration
        val eventBus = FMLJavaModLoadingContext.get().modEventBus
        (Nebular.REGISTRATE as CreateRegistrate).registerEventListeners(eventBus)
        Nebular.init()
    }
}