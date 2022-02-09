package hole7

import java.util.*

internal class TakeHomeCalculator(private val taxRate: TaxRate) {
    fun netAmount(first: Money, vararg rest: Money): Money {
        val total = Arrays.stream(rest).reduce(first) { obj: Money, other: Money -> obj.plus(other) }
        val tax = taxRate.apply(total)
        return total.minus(tax)
    }
}