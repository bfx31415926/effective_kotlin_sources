package snippets.unitTests.myTest1

import C8_Item54.s_2.fibonacci
import org.junit.Test
//import kotlin.test.*
import java.math.BigDecimal
import kotlin.test.assertEquals

class SampleTest {
    @Test
    fun `fib works correctly for the first 5 positions`() {
        assertEquals(BigDecimal(1), fibonacci.take(1).toList()[0])
        assertEquals(BigDecimal(1), fibonacci.take(2).toList()[1])
        assertEquals(BigDecimal(2), fibonacci.take(3).toList()[2])
        assertEquals(BigDecimal(3), fibonacci.take(4).toList()[3])
        assertEquals(BigDecimal(5), fibonacci.take(5).toList()[4])
    }
}
