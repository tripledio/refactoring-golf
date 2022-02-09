package hole7

import hole7.Money.Companion.money

class TaxRate private constructor(private val percent: Int) {
    fun apply(total: Money): Money {
        val amount = total.value * (percent / 100.0)
        return money(amount.toInt(), total.currency)
    }

    companion object {
        fun taxRate(percent: Int): TaxRate {
            return TaxRate(percent)
        }
    }
}