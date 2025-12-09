package f_C5_Item32.s_3

class A

fun b() = A()

val a1 = A()
val a2 = b()

val reference: () -> A = ::A

class A1(val k: Int)

val reference1: (Int) -> A1 = ::A1

fun main(){
    println(reference1(9).k)
}
/*
9
 */