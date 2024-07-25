package net.nebular.content.block

import com.simibubi.create.foundation.block.WrenchableDirectionalBlock
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.DirectionalBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.nebular.content.block.entity.NozzleBlockEntity
//import net.nebular.content.forces.NozzleController
import net.nebular.content.forces.data.NozzleData
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.Ship
import org.valkyrienskies.core.api.ships.getAttachment
import org.valkyrienskies.mod.common.getShipManagingPos
import org.valkyrienskies.mod.common.isBlockInShipyard
import org.valkyrienskies.mod.common.util.toJOMLD

class NozzleBlock(properties: Properties) : WrenchableDirectionalBlock(properties) {

    @Deprecated("need to change")
    override fun onPlace(state: BlockState, level: Level, pos: BlockPos, oldState: BlockState, movedByPiston: Boolean) {
        super.onPlace(state, level, pos, oldState, movedByPiston)
//        val be = NozzleBlockEntity(pos, state)
//        val ship: ServerShip? = level.getShipManagingPos(pos) as ServerShip?
//        be.ship = ship
//        if (ship != null) {
//            be.controller = NozzleController.getOrCreate(ship, NozzleData(level, pos.toJOMLD(), be.vel, be.temp, be.pressure, state.getValue(FACING).normal))
//        }

    }

    @Deprecated("need to change")
    override fun onRemove(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        newState: BlockState,
        movedByPiston: Boolean
    ) {
//        val ship = NozzleBlockEntity(pos, state).ship
//        if (ship != null) {
//            NozzleController.remove(ship)
//        }
        super.onRemove(state, level, pos, newState, movedByPiston)
    }

    @Deprecated("need to change")
    override fun tick(state: BlockState, level: ServerLevel, pos: BlockPos, random: RandomSource) {
        super.tick(state, level, pos, random)
//        val be = NozzleBlockEntity(pos, state)
//        be.ship?.getAttachment<NozzleController>()?.update(be.vel, be.temp, be.pressure, state.getValue(FACING).normal)
    }

}