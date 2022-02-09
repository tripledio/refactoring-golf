package hole4

import hole4.TakeHomeCalculator.Money
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals


class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first: Int =
            TakeHomeCalculator(10).netAmount(
                Money(40, "GBP"),
                Money(50, "GBP"),
                Money(60, "GBP")
            ).value
        assertEquals(135, first.toInt())
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(Incalculable::class.java) {
            TakeHomeCalculator(10).netAmount(Money(4, "GBP"), Money(5, "USD"))
        }
    }
}