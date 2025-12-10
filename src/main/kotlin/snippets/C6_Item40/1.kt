package f_C6_Item40.s_1

class ValueMatcher<T> private constructor(
    private val value: T? = null,
    private val matcher: Matcher
) {

    fun match(value: T?) = when (matcher) {
        Matcher.EQUAL -> value == this.value
        Matcher.NOT_EQUAL -> value != this.value
        Matcher.LIST_EMPTY ->
            value is List<*> && value.isEmpty()

        Matcher.LIST_NOT_EMPTY ->
            value is List<*> && value.isNotEmpty()
    }

    enum class Matcher {
        EQUAL,
        NOT_EQUAL,
        LIST_EMPTY,
        LIST_NOT_EMPTY
    }

    companion object {
        fun <T> equal(value: T) =
            ValueMatcher<T>(
                value = value,
                matcher = Matcher.EQUAL
            )

        fun <T> notEqual(value: T) =
            ValueMatcher<T>(
                value = value,
                matcher = Matcher.NOT_EQUAL
            )

        fun <T> emptyList() =
            ValueMatcher<T>(
                matcher = Matcher.LIST_EMPTY
            )

        fun <T> notEmptyList() =
            ValueMatcher<T>(
                matcher = Matcher.LIST_NOT_EMPTY
            )
    }
}

fun main(){
    val vm: ValueMatcher<Int>
    vm = ValueMatcher.equal(1)
    println("1 == 1: ${vm.match( 1 )}")

    var vm1: ValueMatcher<List<Int>>
    vm1 = ValueMatcher.notEmptyList()
    println("[1, 2, 3] is not empty: ${vm1.match( listOf(1,2,3)) }")

    println("null is not empty list: ${vm1.match( null) }")

    val vm2: ValueMatcher<List<Int>>
    vm2 = ValueMatcher.emptyList()
    println("null is empty list: ${vm2.match( null) }")
}
/*
1 == 1: true
[1, 2, 3] is not empty: true
null is not empty list: false
null is empty list: false
 */