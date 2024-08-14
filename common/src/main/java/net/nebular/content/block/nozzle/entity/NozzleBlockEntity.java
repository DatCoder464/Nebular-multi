package net.nebular.content.block.nozzle.entity;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.nebular.reg.NebularBlockEntities;

import java.util.List;

public class NozzleBlockEntity extends SmartBlockEntity {
    public NozzleBlockEntity(BlockPos pos, BlockState state) {
        super(NebularBlockEntities.NOZZLE.get(), pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {}
}
