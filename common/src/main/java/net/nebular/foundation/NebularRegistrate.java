package net.nebular.foundation;

import com.simibubi.create.foundation.data.CreateBlockEntityBuilder;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nebular.reg.NebularCreativeTabs;

public class NebularRegistrate extends CreateRegistrate {

    public static String autoLang(String id) {
        StringBuilder builder = new StringBuilder();
        boolean b = true;
        for (char c: id.toCharArray()) {
            if(c == '_') {
                builder.append(' ');
                b = true;
            } else {
                builder.append(b ? String.valueOf(c).toUpperCase() : c);
                b = false;
            }
        }
        return builder.toString();
    }

    public ItemEntry<Item> simpleItem(String name) {
        return this.item(name, Item::new)
                .lang(autoLang(name))
                .tab(NebularCreativeTabs.BASE.key)
                .register();
    }

    public <T extends BlockEntity> CreateBlockEntityBuilder<T, CreateRegistrate> blockEntity(
            String name,
            SimpleBlockEntityFactory<T> factory
    ) {
        return super.blockEntity(name, (t, p, s) -> factory.create(p, s));
    }

    public NebularRegistrate(String modid) {
        super(modid);
    }

    public interface SimpleBlockEntityFactory<T extends BlockEntity> {
        T create(BlockPos pos, BlockState state);
    }

}