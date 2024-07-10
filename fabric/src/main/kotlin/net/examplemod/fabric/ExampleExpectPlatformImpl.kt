package net.examplemod.fabric

import net.fabricmc.loader.api.FabricLoader

object ExampleExpectPlatformImpl {
    @JvmStatic
    fun platformName(): String {
        if(FabricLoader.getInstance().isModLoaded("quilt_loader")) {
            return "Quilt"
        }
        return "Fabric"
    }
}