package C1_Item05.myStack

import java.util.Stack

class MyStack : Stack<Int>()

fun MyStack.myPop(p: Int): Int {
    require(p <= size) {
        "Cannot remove more elements than current size"
    }
    return pop()
}


fun main() {
    val stack = MyStack()
    stack.push(15)
    println("stack.size = ${stack.size}")
//    stack.myPop(10) //если раскомментировать, то сработает require(), определенный выше
    val k = stack.myPop(1)
    println("k = $k")
}
/*
stack.size = 1
k = 15
*/