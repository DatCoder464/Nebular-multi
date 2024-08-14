package net.nebular;

import net.minecraft.resources.ResourceLocation;
import net.nebular.foundation.NebularRegistrate;
import net.nebular.reg.NebularBlockEntities;
import net.nebular.reg.NebularBlocks;
import net.nebular.reg.NebularItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Nebular {
    public static final String MOD_ID = "nebular";
    public static final String NAME = "Nebular";


    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static NebularRegistrate REGISTRATE = new NebularRegistrate(MOD_ID);

    public static void init() {
        NebularItems.register();
        NebularBlocks.register();
        NebularBlockEntities.register();

        REGISTRATE.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}