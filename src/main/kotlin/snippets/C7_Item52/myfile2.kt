package C7_Item52.myFile2

interface TimeUnit {
    val millis: Long
}

@JvmInline
value class Minutes(val minutes: Long) {
    val millis: Long get() = minutes * 60 * 1000
}

@JvmInline
value class Millis(val milliseconds: Long) {
    val millis: Long get() = milliseconds
}

inline fun <reified T> setUpTimer(time: T) {
    when (time) {
        is Minutes -> println(time.millis)
        is Millis -> println(time.millis)
    }
}

fun main() {
    setUpTimer(Minutes(123))
    setUpTimer(Millis(456789))
}
/*
7380000
456789
 */
