package net.nebular.reg;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.nebular.Nebular;

public enum NebularCreativeTabs {
    BASE("base")
    ;

    public final ResourceKey<CreativeModeTab> key;
    public final CreativeModeTab tab;

    NebularCreativeTabs(String name) {
        tab = CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 1)
                .title(Component.translatable("itemGroup." + Nebular.MOD_ID + "." + name))
                .build();

        key = getResourceKey(name);
    }

    private ResourceKey<CreativeModeTab> getResourceKey(String name) {
        return ResourceKey.create(Registries.CREATIVE_MODE_TAB, Nebular.asResource(name));
    }

}