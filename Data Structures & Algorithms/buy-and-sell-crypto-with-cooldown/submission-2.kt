class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var hold = -prices[0]
        var sold = 0
        var rest = 0

        for (i in 1 until prices.size) {
            val prevSold = sold

            sold = hold + prices[i]
            hold = maxOf(hold, rest - prices[i])
            rest = maxOf(rest, prevSold)
        }

        return maxOf(sold, rest)
    }
}