package net.nebular.reg;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.nebular.Nebular;
import net.nebular.foundation.NebularRegistrate;

import java.util.Collection;

public class NebularItems {
    private static final NebularRegistrate REGISTRATE = Nebular.REGISTRATE;


    public static final ItemEntry<Item>
            TITANIUM = REGISTRATE.simpleItem("titanium_ingot"),
            TITANIUM_ALUMINIDE  = REGISTRATE.simpleItem("titanium_aluminide_ingot");


    public static final Collection<RegistryEntry<Item>> ENTRIES = REGISTRATE.getAll(BuiltInRegistries.ITEM.key());

    public static void register() {}
}