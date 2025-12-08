package C1_Item02.myBigInteger

import java.math.BigDecimal

fun main() {
    val num1 = BigDecimal("1.0")
    val num2 = BigDecimal("1.00")
    println(num1 == num2) // false
    println(num1 >= num2 && num1 <= num2) // true
    println(num1.compareTo(num2) == 0) // true
}
/*
false
true
true
 */