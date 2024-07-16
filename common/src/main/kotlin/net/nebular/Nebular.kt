package net.nebular

import com.simibubi.create.foundation.data.CreateRegistrate
import net.minecraft.resources.ResourceLocation
import net.nebular.foundation.NebularRegistrate
import net.nebular.reg.NebularBlocks
import net.nebular.reg.NebularCreativeTabs
import net.nebular.reg.NebularCreativeTabs.BASE
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Nebular {
    const val MOD_ID = "nebular"
    const val NAME = "Nebular"

    @JvmStatic
    val LOGGER: Logger = LoggerFactory.getLogger(NAME)
    val REGISTRATE: NebularRegistrate = NebularRegistrate(MOD_ID)

    @JvmStatic
    fun init() {
        NebularBlocks.register()
        NebularCreativeTabs.register()

        REGISTRATE.register()
    }

    fun asResource(path: String): ResourceLocation =
        ResourceLocation(MOD_ID, path)

}