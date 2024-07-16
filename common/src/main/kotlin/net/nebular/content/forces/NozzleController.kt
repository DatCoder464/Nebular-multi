package net.nebular.content.forces

import net.minecraft.util.Mth
import net.nebular.content.block.entity.NozzleBlockEntity
import net.nebular.content.forces.data.UpdateData
import org.joml.Vector3d
import org.joml.Vector3dc
import org.valkyrienskies.core.api.ships.PhysShip
import org.valkyrienskies.core.api.ships.ServerShip
import org.valkyrienskies.core.api.ships.ShipForcesInducer
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl
import org.valkyrienskies.mod.common.util.toJOMLD
import java.lang.Double.isFinite
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

class NozzleController: ShipForcesInducer {
    private val data: ConcurrentHashMap<Int, NozzleBlockEntity> = ConcurrentHashMap()
    private val updates: UpdateData<NozzleBlockEntity> = UpdateData(
        ConcurrentLinkedQueue<NozzleBlockEntity>(),
        ConcurrentLinkedQueue<Int>()
    ) //first is created second is removed
    private var nextID = 0

    override fun applyForces(physShip: PhysShip) {
        while (!updates.created.isEmpty()) {
            val createdData: NozzleBlockEntity = updates.created.remove()
            data.put(
                createdData.ID,
                createdData
            )
        }
        while (!updates.destroyed.isEmpty()) {
            data.remove(updates.destroyed.remove())
        }

        for (blockData in data.values) {
            val pos: Vector3dc =
                blockData.blockPos.toJOMLD().add(0.5, 0.5, 0.5, Vector3d()).sub(physShip.transform.positionInShip)
            val force = computeForce(blockData, physShip as PhysShipImpl)
            physShip.applyRotDependentForceToPos(force, pos)
        }
    }

    fun computeForce(blockData: NozzleBlockEntity, ship: PhysShipImpl): Vector3dc {
        val data = blockData.data
        val dir: Vector3dc = Vector3d()
        var providedForce = 0.0
        val airPress = airPressure(ship.transform.positionInWorld)
        val fanPosRelCenterMass: Vector3dc = ship.transform.shipToWorld.transformPosition(
            blockData.blockPos.toJOMLD().add(0.5, 0.5, 0.5, Vector3d()),
            Vector3d()
        ).sub(ship.transform.positionInWorld, Vector3d())
        val worldVelAtFan: Vector3dc = ship.poseVel.omega.cross(fanPosRelCenterMass, Vector3d())
            .add(ship.poseVel.vel, Vector3d())
        val exhaustVel = data.vel
        var factor = 1.0 - Mth.clamp(dir.dot(worldVelAtFan) / exhaustVel, 0.0, 1.0)
        if (!isFinite(factor)) {
            factor = 0.0
        }

        providedForce *= airPress * factor
        return Vector3d(dir).mul(providedForce)
    }

    private fun airPressure(pos: Vector3dc): Double {
        val SEA_LEVEL = 64.0
        val WORLD_HEIGHT = 320.0
        val FALLOFF_POINT = 192.0
        val offset = Math.exp(-(WORLD_HEIGHT - SEA_LEVEL) / FALLOFF_POINT)
        val height = pos.y()
        val airPress = (Math.exp(-(height - SEA_LEVEL) / FALLOFF_POINT) - offset) / (1.0 - offset)
        return if (isFinite(airPress)) {
            Mth.clamp(airPress, 0.0, 1.0)
        } else {
            0.0
        }
    }

    fun addNozzle(data: NozzleBlockEntity): Int {
            val id = nextID++
            data.ID = id
        updates.created.add(data)
        return id
    }

    fun removeNozzle(id: Int) {
        updates.destroyed.add(id)
    }

    companion object {
        fun getOrCreate(ship: ServerShip): NozzleController? {
            if (ship.getAttachment(NozzleController::class.java) == null) {
                ship.saveAttachment(NozzleController::class.java, NozzleController())
            }
            return ship.getAttachment(NozzleController::class.java)
        }
    }
}