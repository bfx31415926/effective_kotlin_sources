package f_C5_Item32.s_4

public inline fun <T> List(
    size: Int,
    init: (index: Int) -> T
): List<T> = MutableList(size, init)

public inline fun <T> MutableList(
    size: Int,
    init: (index: Int) -> T
): MutableList<T> {
    val list = ArrayList<T>(size)
    repeat(size) { index -> list.add(init(index)) }
    return list
}

fun main(){
    val list = List(10){it ->it * it}
    println("list = $list")

    val mutableList = MutableList(10){it -> it + 10}
    println("mutableList = $mutableList")
}
/*
list = [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
mutableList = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
 */