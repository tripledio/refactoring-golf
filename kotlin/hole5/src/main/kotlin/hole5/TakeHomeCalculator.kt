package hole5

import hole5.Money.Companion.money
import java.util.Arrays

internal class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Money, vararg rest: Money?): Money {
        val monies = Arrays.asList(*rest)
        var total = first
        for (next in monies) {
            total = total.plus(next!!)
        }
        val amount = total.value * (percent / 100.0)
        val tax: Money = money(amount.toInt(), first.currency)
        return total.minus(tax)
    }
}