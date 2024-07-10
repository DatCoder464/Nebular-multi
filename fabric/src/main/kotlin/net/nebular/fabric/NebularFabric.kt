package net.nebular.fabric

import com.simibubi.create.foundation.data.CreateRegistrate
import io.github.fabricators_of_create.porting_lib.util.EnvExecutor
import net.nebular.Nebular
import net.fabricmc.api.ModInitializer
import java.util.function.Supplier

class NebularFabric : ModInitializer {
    override fun onInitialize() {
        Nebular.init()
        val clientLog: Supplier<Supplier<String>> = Supplier {  Supplier { "${Nebular.NAME} is accessing Porting Lib on a Fabric client!" } }

        val serverLog: Supplier<Supplier<String>> = Supplier { Supplier { "${Nebular.NAME} is accessing Porting Lib on a Fabric server!" } }
        Nebular.LOGGER.info(EnvExecutor.unsafeRunForDist(clientLog, serverLog))
        (Nebular.REGISTRATE as CreateRegistrate).register()
    }
}