package net.examplemod

import com.simibubi.create.Create
import com.simibubi.create.foundation.data.CreateRegistrate
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ExampleMod {
    const val MOD_ID = "examplemod"
    const val NAME = "Example Mod"
    @JvmStatic
    val LOGGER: Logger = LoggerFactory.getLogger(NAME)
    val REGISTRATE: CreateRegistrate = CreateRegistrate.create(MOD_ID)

    @JvmStatic
    fun init() =
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, ExampleExpectPlatform.platformName())

    fun id(path: String): ResourceLocation =
        ResourceLocation(MOD_ID, path)
}