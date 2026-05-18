class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val sum = nums.sum()
        
        // If target is impossible to reach or sum + target is odd
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0
        }
        
        // We need to find a subset with sum = (sum + target) / 2
        val subsetSum = (sum + target) / 2
        
        // DP array where dp[i] = number of ways to get sum i
        val dp = IntArray(subsetSum + 1)
        dp[0] = 1 // One way to get sum 0 (empty subset)
        
        for (num in nums) {
            for (j in subsetSum downTo num) {
                dp[j] += dp[j - num]
            }
        }
        
        return dp[subsetSum]
    }
}