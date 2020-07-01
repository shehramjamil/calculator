import org.junit.Test
import org.junit.Assert.*
import sample.calculator.android.R
import sample.calculator.arithmeticparser.Fibonacci

class FibonacciTest
{
    @Test
    fun negativeInputTest()
    {
        assertEquals("0.0", Fibonacci("-21").findFibonacciSum())
    }
    @Test
    fun anyCharacterInputTest()
    {
        assertEquals(R.string.only_number, Fibonacci("@#$^").findFibonacciSum())
    }
    @Test
    fun smallPositiveNumberInputTest()
    {
        assertEquals("144.0", Fibonacci("12").findFibonacciSum())
    }
    @Test
    fun bigNumberInputTest()
    {
        assertEquals("4.346655768693743E208", Fibonacci("1000").findFibonacciSum())
    }
}