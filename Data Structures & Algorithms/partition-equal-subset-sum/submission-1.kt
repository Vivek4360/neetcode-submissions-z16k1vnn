class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        
        // If total sum is odd, we cannot partition into equal subsets
        if (totalSum % 2 != 0) {
            return false
        }
        
        val target = totalSum / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true // Empty subset sums to 0
        
        for (num in nums) {
            // Traverse backwards to avoid using the same element multiple times
            for (j in target downTo num) {
                dp[j] = dp[j] || dp[j - num]
            }
        }
        
        return dp[target]
    }
}