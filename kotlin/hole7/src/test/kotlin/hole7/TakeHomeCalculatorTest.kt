package hole7

import hole7.Money.Companion.money
import hole7.TaxRate.Companion.taxRate
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals


class TakeHomeCalculatorTest {
    @Test
    @Throws(Exception::class)
    fun canCalculateTax() {
        val first: Int =
            TakeHomeCalculator(taxRate(10)).netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP")).value
        assertEquals(135, first)
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(Incalculable::class.java) {
            TakeHomeCalculator(taxRate(10)).netAmount(
                money(
                    4,
                    "GBP"
                ), money(5, "USD")
            )
        }
    }
}