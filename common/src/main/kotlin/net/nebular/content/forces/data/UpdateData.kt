package net.nebular.content.forces.data

import net.nebular.content.block.entity.NozzleBlockEntity
import java.util.concurrent.ConcurrentLinkedQueue

data class UpdateData<T>(val created: ConcurrentLinkedQueue<T>, val destroyed: ConcurrentLinkedQueue<Int>) {

    fun moreCreated(): Boolean {
        return !created.isEmpty()
    }

    fun moreDestroyed(): Boolean {
        return !destroyed.isEmpty()
    }

}
