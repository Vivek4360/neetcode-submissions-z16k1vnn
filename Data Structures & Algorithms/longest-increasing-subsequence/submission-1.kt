class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        val n = nums.size
        // dp[i] represents the length of LIS ending at index i
        val dp = IntArray(n) { 1 }
        
        var maxLen = 1
        
        // For each position, look back at previous positions
        for (i in 1 until n) {
            for (j in 0 until i) {
                // If current element is greater than previous element
                if (nums[i] > nums[j]) {
                    // Update LIS ending at i
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            maxLen = maxOf(maxLen, dp[i])
        }
        
        return maxLen
    }
}