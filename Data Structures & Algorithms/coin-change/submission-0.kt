class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // dp[i] represents the minimum coins needed to make amount i
        val dp = IntArray(amount + 1) { amount + 1 }
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0
        
        // For each amount from 1 to target amount
        for (i in 1..amount) {
            // Try each coin denomination
            for (coin in coins) {
                if (coin <= i) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it's impossible
        return if (dp[amount] > amount) -1 else dp[amount]
    }
}