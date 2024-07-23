package net.nebular.content.forces.data

import net.minecraft.core.Vec3i
import net.minecraft.world.level.Level
import org.joml.Vector3dc

data class NozzleData(val level: Level, val pos: Vector3dc, var vel: Double, var pressure : Double, var temp: Double, var dir: Vec3i)
