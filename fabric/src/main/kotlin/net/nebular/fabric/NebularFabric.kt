package net.nebular.fabric

import net.nebular.Nebular
import net.fabricmc.api.ModInitializer
import net.minecraft.client.Minecraft

class NebularFabric : ModInitializer {
    override fun onInitialize() {
        Nebular.init()
        Minecraft.getInstance().resourceManager
    }
}