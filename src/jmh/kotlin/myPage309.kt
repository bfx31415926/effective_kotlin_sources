package jmh.kotlin

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole

open class MyPage309 {

    fun noinlineRepeat(times: Int, action: (Int) -> Unit) {
        for (index in 0 until times) {
            action(index)
        }
    }


    @Benchmark
    fun nothingInline(blackhole: Blackhole) {
        repeat(100_000_000) {
            blackhole.consume(it)
        }
    }

    @Benchmark
    fun nothingNoninline(blackhole: Blackhole) {
        noinlineRepeat(100_000_000) {
            blackhole.consume(it)
        }
    }
}
