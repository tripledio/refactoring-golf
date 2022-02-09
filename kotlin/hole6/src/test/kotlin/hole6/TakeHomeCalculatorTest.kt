package hole6

import hole6.Money.Companion.money
import hole6.TaxRate.Companion.taxRate
import org.junit.jupiter.api.*

class TakeHomeCalculatorTest {
    @Test
    fun canCalculateTax() {
        val first =
            TakeHomeCalculator(taxRate(10)).netAmount(money(40, "GBP"), money(50, "GBP"), money(60, "GBP")).value
        Assertions.assertEquals(135, first)
    }

    @Test
    fun cannotSumDifferentCurrencies() {
        Assertions.assertThrows(Incalculable::class.java)
        {
            TakeHomeCalculator(taxRate(10)).netAmount(
                money(
                    4,
                    "GBP"
                ), money(5, "USD")
            )
        }
    }
}