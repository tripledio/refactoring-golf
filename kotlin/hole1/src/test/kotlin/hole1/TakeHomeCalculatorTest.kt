package hole1

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first: Int = TakeHomeCalculator(10).netAmount(Pair(40, "GBP"), Pair(50, "GBP"), Pair(60, "GBP")).first
        assertEquals(135, first)
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(hole1.Incalculable::class.java) {
            TakeHomeCalculator(10).netAmount(Pair(4, "GBP"), Pair(5, "USD"))
        }
    }
}