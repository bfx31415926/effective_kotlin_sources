package C1_Item02.myFile2

import kotlin.concurrent.thread

fun main(){
    var numbers = mutableListOf<Int>()
    for (i in 1..1000) {
        thread {
            Thread.sleep(1)
            numbers.add(i)
        }
        thread {
            Thread.sleep(1)
            print(numbers.sum()) // sum iterates over the list
            // often ConcurrentModificationException
        }
    }
}
