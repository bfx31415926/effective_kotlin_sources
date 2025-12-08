/*
Смирнов: в это йпрограмме компилятор не ругается на
clq.add(null), но программа на нем вылетает!
 */
package C1_Item02.myFile7

import java.util.concurrent.ConcurrentLinkedQueue

fun main() {
    val clq = ConcurrentLinkedQueue<Int>()
    clq.add(null)
}
