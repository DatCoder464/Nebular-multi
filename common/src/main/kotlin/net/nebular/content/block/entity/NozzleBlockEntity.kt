package net.nebular.content.block.entity

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour
import net.minecraft.core.BlockPos
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.level.block.state.BlockState
import net.nebular.content.forces.NozzleController
import net.nebular.content.forces.data.NozzleData
import net.nebular.reg.NebularBlockEntity
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.Ship
import org.valkyrienskies.mod.common.getShipManagingPos

class NozzleBlockEntity(pos: BlockPos, blockState: BlockState) : SmartBlockEntity(NebularBlockEntity.NOZZLE.get(), pos, blockState) {
    //var data: NozzleData
    var controller: NozzleController? = null
    var ID: Int = -1

    override fun addBehaviours(behaviours: MutableList<BlockEntityBehaviour>?) {}

    override fun write(compound: CompoundTag?, clientPacket: Boolean) {
        super.write(compound, clientPacket)
        if (!clientPacket)
            return
        compound?.putDouble("Pressure", data.presure)
        compound?.putDouble("Temperature", data.temp)
        compound?.putDouble("Velocity", data.vel)
    }

    override fun read(compound: CompoundTag?, clientPacket: Boolean) {
        super.read(compound, clientPacket)
        if (!clientPacket)
            return
        compound!!
        data.presure = compound.getDouble("Pressure")
        data.temp = compound.getDouble("Temperature")
        data.vel = compound.getDouble("Velocity")
    }
}

//	@Override
//	protected void write(CompoundTag compound, boolean clientPacket) {
//		super.write(compound, clientPacket);
//		if (!clientPacket)
//			return;
//		compound.putFloat("Range", range);
//		compound.putBoolean("Pushing", pushing);
//	}
//
//	@Override
//	protected void read(CompoundTag compound, boolean clientPacket) {
//		super.read(compound, clientPacket);
//		if (!clientPacket)
//			return;
//		range = compound.getFloat("Range");
//		pushing = compound.getBoolean("Pushing");
//	}