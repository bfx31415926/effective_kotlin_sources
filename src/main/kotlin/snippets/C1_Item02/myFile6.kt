package C1_Item02.myFile6

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.concurrent.thread

fun main(){
    val set = ConcurrentHashMap.newKeySet<Int>()
    for (i in 1..1000) {
        thread {
            Thread.sleep(1)
            set += i
        }
    }
    Thread.sleep(5000)
    println(set.size)
 }
/*
1000
 */
