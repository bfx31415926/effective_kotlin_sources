package C7_Item52.myFile1

interface TimeUnit {
    val millis: Long
}

@JvmInline
value class Minutes(val minutes: Long) : TimeUnit {
    override val millis: Long get() = minutes * 60 * 1000
}

@JvmInline
value class Millis(val milliseconds: Long) : TimeUnit {
    override val millis: Long get() = milliseconds
}

// the type under the hood is TimeUnit
fun setUpTimer(time: TimeUnit) {
    val millis = time.millis
    println(millis)
}

fun main() {
    setUpTimer(Minutes(123))
    setUpTimer(Millis(456789))
}
/*
Комментарии: В этой программе, несмотря на va value-классы,
компилятор вынужден создавать классы, когда они приводятся к интерфейсу или
общему типу.
В похожем классе myFile2.kt классы не создаюся.
*/
 /*
7380000
456789
 */
