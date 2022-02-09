package hole3

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals


class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first: Int =
            TakeHomeCalculator(10).netAmount(
                TakeHomeCalculator.Money(40, "GBP"),
                TakeHomeCalculator.Money(50, "GBP"),
                TakeHomeCalculator.Money(60, "GBP")
            ).value
        assertEquals(135, first.toInt())
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(hole3.Incalculable::class.java) {
            TakeHomeCalculator(10).netAmount(TakeHomeCalculator.Money(4, "GBP"), TakeHomeCalculator.Money(5, "USD"))
        }
    }


}