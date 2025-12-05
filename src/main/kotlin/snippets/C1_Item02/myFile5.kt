package C1_Item02.myFile5

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

fun main(){
    val num = AtomicInteger(0)
    for (i in 1..1000) {
        thread {
//            Thread.sleep(10)
            num.incrementAndGet()
        }
    }
    Thread.sleep(5000)
    print(num.get()) // 1000
 }
