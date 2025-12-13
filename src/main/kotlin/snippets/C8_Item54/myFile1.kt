package C8_Item54.myFile1

fun main() {
    (1..10).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }
}
/*
F1, M1, F2, F3, M3,
 */