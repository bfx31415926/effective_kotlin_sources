package C1_Item01.myFile1

import kotlin.concurrent.thread

fun main() {
    var list = listOf<Int>()
    for (i in 1..1000) {
        thread {
            list = list + i
        }
    }

    Thread.sleep(1000)
    print(list.size) // Very unlikely to be 1000,
    // every time a different number, like for instance 911
}
