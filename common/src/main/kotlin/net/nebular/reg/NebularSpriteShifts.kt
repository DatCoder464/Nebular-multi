package net.nebular.reg

import com.simibubi.create.foundation.block.connected.AllCTTypes
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry
import com.simibubi.create.foundation.block.connected.CTSpriteShifter
import com.simibubi.create.foundation.block.connected.CTType
import com.sun.jna.platform.unix.solaris.LibKstat.KstatNamed.UNION.STR
import net.nebular.Nebular

object NebularSpriteShifts {

    val HULL: CTSpriteShiftEntry = omni("ship_hull")

    fun omni(name : String): CTSpriteShiftEntry =
        getCT(AllCTTypes.OMNIDIRECTIONAL, name)

    fun horizontal(name : String) =
        getCT(AllCTTypes.HORIZONTAL, name)

    fun vertical(name : String) =
        getCT(AllCTTypes.VERTICAL, name)

    fun getCT(type: CTType, blockTextureName : String, connectedTextureName: String) =
        CTSpriteShifter.getCT(type, Nebular.asResource("block/" + blockTextureName),
            Nebular.asResource("block/" + connectedTextureName + "_connected"))

    fun getCT(type: CTType, blockTextureName : String) =
        getCT(type, blockTextureName, blockTextureName)
}