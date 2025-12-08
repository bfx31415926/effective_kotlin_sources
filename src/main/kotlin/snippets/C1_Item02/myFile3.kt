package C1_Item02.myFile3

import kotlin.concurrent.thread

fun main() {
    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }
    Thread.sleep(1000)
    print(num) // 1000
}
/*
1000
 */