package f_C4_Item30.s_1
import kotlin.system.measureNanoTime

/**
 * Powerset returns a set of all subsets of the receiver
 * including itself and the empty set
 */
fun <T> Collection<T>.powerset(): Set<Set<T>> =
    if (isEmpty()) setOf(emptySet())
    else take(size - 1)
        .powerset()
        .let { it + it.map { it + last() } }

fun main() {
    val list = (1..18).toSet()
    val timeTaken = measureNanoTime {
        list.powerset()
    }

    println("Время выполнения: ${timeTaken / 1_000_000_000.0} сек")
}
/*
на моем компе:
Время выполнения: 27.2705024 сек
 */