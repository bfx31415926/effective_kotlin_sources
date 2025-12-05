package C1_Item02.myFile1

import kotlin.concurrent.thread

fun main(){
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            num += 1
        }
    }
    Thread.sleep(5000)
    print(num) // Very unlikely to be 1000
// Every time a different number
}
