package net.nebular.fabric

import net.nebular.Nebular
import net.fabricmc.api.ModInitializer
import net.nebular.reg.NebularBlocks

class NebularFabric : ModInitializer {
    override fun onInitialize() {
        Nebular.init()
    }
}