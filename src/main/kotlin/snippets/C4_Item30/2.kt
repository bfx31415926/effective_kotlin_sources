package f_C4_Item30.s_2

import f_C4_Item30.s_1.powerset
import kotlin.system.measureNanoTime

/**
 * Powerset returns a set of all subsets of the receiver
 * including itself and empty set
 */
fun <T> Collection<T>.powerset(): Set<Set<T>> =
    powerset(this, setOf(setOf()))

private tailrec fun <T> powerset(
    left: Collection<T>,
    acc: Set<Set<T>>
): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else -> {
        val head = left.first()
        val tail = left.drop(1)
        powerset(tail, acc + acc.map { it + head })
    }
}

fun main(){
    val list = (1..18).toSet()
    val timeTaken = measureNanoTime {
        list.powerset()
    }

    println("Время выполнения: ${timeTaken/1_000_000_000.0} сек")
}
/*
на моем компе (странно, что код выполняется даже тольше, чем в C4_item30\1.kt):
Время выполнения:27.4784102 сек
 */