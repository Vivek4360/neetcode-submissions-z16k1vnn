class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        
    val n = cost.size
    val dp = IntArray(n + 1)
    
    dp[n] = 0
    dp[n - 1] = cost[n - 1]
    
    for (i in n - 2 downTo 0) {
        dp[i] = cost[i] + minOf(dp[i + 1], dp[i + 2])
    }
    
    return minOf(dp[0], dp[1])




    }
}
