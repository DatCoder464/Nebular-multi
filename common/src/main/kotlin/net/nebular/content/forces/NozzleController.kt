package net.nebular.content.forces

import net.minecraft.core.Vec3i
import net.nebular.APfun
import net.nebular.content.forces.data.NozzleData
import org.joml.Vector3d
import org.joml.Vector3dc
import org.valkyrienskies.core.api.ships.*
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl
import org.valkyrienskies.mod.common.dimensionId
import org.valkyrienskies.mod.common.util.toJOMLD
import org.valkyrienskies.core.api.ships.ShipForcesInducer

class NozzleController(private var data: NozzleData): ShipForcesInducer {

    fun update(vel: Double, pressure : Double, temp: Double, dir: Vec3i) {
        data.vel = vel
        data.pressure = pressure
        data.temp = temp
        data.dir = dir
    }

    override fun applyForces(physShip: PhysShip) {
        val pos: Vector3dc =
            data.pos.add(0.5, 0.5, 0.5, Vector3d()).sub(physShip.transform.positionInShip)
        val force = computeForce(physShip as PhysShipImpl)
        physShip.applyRotDependentForceToPos(force, pos)
    }

    private fun computeForce(ship: PhysShipImpl): Vector3dc {
        val dir: Vector3dc = ship.transform.shipToWorldRotation.transform(data.dir.toJOMLD())
        return Vector3d(dir).mul( (data.vel * 2.0) + (data.pressure - atmoPressure(ship.transform.positionInWorld)))
    }

    private fun atmoPressure(pos: Vector3dc): Double {
        return data.level.dimensionId.APfun.invoke(pos)
    }

    companion object {
        fun getOrCreate(ship: ServerShip, data: NozzleData): NozzleController? {
            if (ship.getAttachment<NozzleController>() == null) {
                ship.saveAttachment<NozzleController>(NozzleController(data))
            }
            return ship.getAttachment<NozzleController>()
        }

        fun remove(ship: ServerShip) {
            ship.saveAttachment<NozzleController>(null)
        }
    }

}