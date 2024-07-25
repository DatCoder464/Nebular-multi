package net.nebular.content.forces

import net.minecraft.core.Vec3i
import net.nebular.APfun
import net.nebular.content.forces.data.NozzleData
import org.joml.*
import org.valkyrienskies.core.api.ships.*
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl
import org.valkyrienskies.mod.common.dimensionId
import org.valkyrienskies.mod.common.util.toJOMLD

//class NozzleController(private var data: NozzleData): ShipForcesInducer {
//
//    fun update(vel: Double, pressure : Double, temp: Double, dir: Vec3i) {
//        data.vel = vel
//        data.pressure = pressure
//        data.temp = temp
//        data.dir = dir
//    }
//
//    override fun applyForces(physShip: PhysShip) {
//        val pos: Vector4d? = physShip.transform.shipToWorld.transform(Vector4d(data.pos.x() + (0.5 * data.dir.x), data.pos.y() + (0.5 * data.dir.y), data.pos.z() + (0.5 * data.dir.z), 0.0))
//        if(pos != null) {
//            val force = computeForce(physShip as PhysShipImpl)
//            physShip.applyRotDependentForceToPos(force, Vector3d(pos.x, pos.y, pos.z))
//        }
//    }
//
//    private fun computeForce(ship: PhysShipImpl): Vector3dc {
//        val dir: Vector3dc = ship.transform.shipToWorldRotation.transform(data.dir.toJOMLD())
//        return Vector3d(dir).mul( (data.vel * 2.0) + (data.pressure - atmoPressure(ship.transform.positionInWorld)))
//    }
//
//    private fun atmoPressure(pos: Vector3dc): Double {
//        return data.level.dimensionId.APfun(pos)
//    }
//
//    companion object {
//        fun getOrCreate(ship: ServerShip, data: NozzleData): NozzleController? {
//            if (ship.getAttachment<NozzleController>() == null) {
//                ship.saveAttachment<NozzleController>(NozzleController(data))
//            }
//            return ship.getAttachment<NozzleController>()
//        }
//
//        fun remove(ship: ServerShip) {
//            ship.saveAttachment<NozzleController>(null)
//        }
//    }
//
//}