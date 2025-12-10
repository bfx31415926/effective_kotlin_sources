package C6_Item40.MyFile3

sealed class ValueMatcher<T> {
    abstract fun match(value: T?): Boolean
}

class Equal<T>(val value: T) : ValueMatcher<T>() {
    override fun match(value: T?): Boolean =
        value == this.value
}

class NotEqual<T>(val value: T) : ValueMatcher<T>() {
    override fun match(value: T?): Boolean =
        value != this.value
}

class EmptyList<T>() : ValueMatcher<T>() {
    override fun match(value: T?) =
        value is List<*> && value.isEmpty()
}

class NotEmptyList<T>() : ValueMatcher<T>() {
    override fun match(value: T?) =
        value is List<*> && value.isNotEmpty()
}

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
