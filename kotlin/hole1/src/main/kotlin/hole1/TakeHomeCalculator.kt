package hole1

import java.util.*

class TakeHomeCalculator(private val percent: Int) {
    fun netAmount(first: Pair<Int, String>, vararg rest: Pair<Int, String>): Pair<Int, String> {
        val pairs: List<Pair<Int, String>> = rest.asList()
        var total: Pair<Int, String> = first
        for (next in pairs) {
            if (next.second !== total.second) {
                throw Incalculable()
            }
        }
        for (next in pairs) {
            total = Pair(total.first + next.first, next.second)
        }
        val amount: Double = total.first * (percent / 100.0)
        val tax: Pair<Int, String> = Pair(amount.toInt(), first.second)
        return if (total.second === tax.second) {
            Pair(total.first - tax.first, first.second)
        } else {
            throw Incalculable()
        }
    }

}