package C1_Item05.myFile1

fun main(){
    val list = listOf<Int>(1,2,3,4,5,6,7,8)
    val list1 = list.take(5)
    val list2 = list.drop(1)
    println("list1 = $list1")
    println("list2 = $list2")
    println("list = $list")
}
/*
list1 = [1, 2, 3, 4, 5]
list2 = [2, 3, 4, 5, 6, 7, 8]
list = [1, 2, 3, 4, 5, 6, 7, 8]
 */