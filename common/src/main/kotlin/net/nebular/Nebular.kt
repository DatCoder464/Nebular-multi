package net.nebular

import com.simibubi.create.Create
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Nebular {
    const val MOD_ID = "examplemod"
    const val NAME = "Example Mod"
    @JvmStatic
    val LOGGER: Logger = LoggerFactory.getLogger(NAME)
    val REGISTRATE: NebularRegistrate = NebularRegistrate(MOD_ID)

    @JvmStatic
    fun init() =
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName())

    fun asResource(path: String): ResourceLocation =
        ResourceLocation(MOD_ID, path)
}