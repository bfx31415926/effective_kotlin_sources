package C6_Item40.MyFile4

import C6_Item40.MyFile3.*

fun main(){
    println("1 == 1: ${Equal<Int>(1).match(1)}")
    println("[1, 2, 3] is not empty: " +
            "${NotEmptyList<List<Int>>().match(listOf(1,2,3))}")
    println("null is not empty list: " +
            "${NotEmptyList<List<Int>>().match(null)}")
    println("null is empty list: " +
            "${EmptyList<List<Int>>().match(null)}")
}
/*
1 == 1: true
[1, 2, 3] is not empty: true
null is not empty list: false
null is empty list: false
 */
