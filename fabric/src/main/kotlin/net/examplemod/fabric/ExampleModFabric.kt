package net.examplemod.fabric

import com.simibubi.create.foundation.data.CreateRegistrate
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor
import net.examplemod.ExampleMod
import net.fabricmc.api.ModInitializer
import java.util.function.Supplier

class ExampleModFabric : ModInitializer {
    override fun onInitialize() {
        ExampleMod.init()
        val clientLog: Supplier<Supplier<String>> = Supplier {  Supplier { "${ExampleMod.NAME} is accessing Porting Lib on a Fabric client!" } }

        val serverLog: Supplier<Supplier<String>> = Supplier { Supplier { "${ExampleMod.NAME} is accessing Porting Lib on a Fabric server!" } }
        ExampleMod.LOGGER.info(EnvExecutor.unsafeRunForDist(clientLog, serverLog))
        (ExampleMod.REGISTRATE as CreateRegistrate).register()
    }
}