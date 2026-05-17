class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        // dp[i] represents the number of combinations to make amount i
        val dp = IntArray(amount + 1)
        
        // Base case: there's 1 way to make amount 0 (using no coins)
        dp[0] = 1
        
        // For each coin, update the dp array
        for (coin in coins) {
            for (i in coin..amount) {
                dp[i] += dp[i - coin]
            }
        }
        
        return dp[amount]
    }
}