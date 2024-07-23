package net.nebular

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.util.Mth
import net.minecraft.world.level.Level
import net.minecraft.world.level.Level.*
import org.joml.Vector3dc
import org.valkyrienskies.core.apigame.world.properties.DimensionId
import org.valkyrienskies.mod.common.dimensionId

val dimensionAtmos: MutableMap<DimensionId, (Vector3dc) -> Double> = mutableMapOf(
    Pair(getDim(OVERWORLD).dimensionId) {
        pos: Vector3dc ->
        val SEA_LEVEL = 64.0
        val WORLD_HEIGHT = 320.0
        val FALLOFF_POINT = 192.0
        val offset = Math.exp(-(WORLD_HEIGHT - SEA_LEVEL) / FALLOFF_POINT)
        val height = pos.y()
        val airPress = (Math.exp(-(height - SEA_LEVEL) / FALLOFF_POINT) - offset) / (1.0 - offset)
        if (java.lang.Double.isFinite(airPress)) Mth.clamp(airPress, 0.0, 1.0) else 0.0
    }, Pair(getDim(NETHER).dimensionId) {
        pos: Vector3dc ->
        0.0
    }, Pair(getDim(END).dimensionId) {
        pos: Vector3dc ->
        0.0
    })

var DimensionId.APfun: (Vector3dc) -> Double
    set(atmoFun) = addDim(this, atmoFun)
    get() = dimensionAtmos[this]!!

fun addDim(id: DimensionId, atmoFun: (Vector3dc) -> Double) {
    dimensionAtmos[id] = atmoFun
}

fun getDim(key: ResourceKey<Level>): Level {
    return BuiltInRegistries.REGISTRY[Registries.DIMENSION.registry()]?.get(key.location()) as Level
}
