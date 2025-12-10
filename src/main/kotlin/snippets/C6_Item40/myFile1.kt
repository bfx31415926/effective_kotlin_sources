package C6_Item40.myFile1

import f_C6_Item40.s_2.ValueMatcher

fun <T> ValueMatcher<T>.out() =
    when (this) {
        is ValueMatcher.NotEmptyList -> println("ValueMatcher.NotEmptyList")
        is ValueMatcher.EmptyList -> println("ValueMatcher.EmptyList")
        is ValueMatcher.NotEqual -> println("ValueMatcher.NotEqual")
        is ValueMatcher.Equal -> println("ValueMatcher.Equal")
    }

fun main(){
    ValueMatcher.NotEmptyList<Int>().out()
}
/*
ValueMatcher.NotEmptyList
 */
