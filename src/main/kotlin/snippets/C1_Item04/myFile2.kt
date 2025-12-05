/*
Нахождение первых десяти простых чисел(НЕкорректная версия)
 */
package C1_Item04.myFile2

fun main() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }
        var prime: Int
        while (true) {
            prime = numbers.first()
            yield(prime)
//            println("prime = $prime")
            numbers = numbers.drop(1)
                .filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
}
/*
 вместо правильного списка [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
 программа выводит НЕПРАВИЛЬНЫЙ: [2, 3, 5, 6, 7, 8, 9, 10, 11, 12]
 */