package hole6

import hole6.Money.Companion.money

class TaxRate private constructor(val percent: Int) {

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