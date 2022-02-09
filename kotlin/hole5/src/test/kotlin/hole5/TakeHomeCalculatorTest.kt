package hole5

import hole5.Money.Companion.money
import org.junit.jupiter.api.*

class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first = TakeHomeCalculator(10).netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP")).value
        Assertions.assertEquals(135, first)
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(Incalculable::class.java) {
            TakeHomeCalculator(10).netAmount(money(4, "GBP"), money(5, "USD"))
        }
    }
}