class Solution {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        // Add boundary balloons with value 1
        val balloons = IntArray(n + 2)
        balloons[0] = 1
        balloons[n + 1] = 1
        System.arraycopy(nums, 0, balloons, 1, n)
        
        val dp = Array(n + 2) { IntArray(n + 2) }
        
        // Length of subarray to consider
        for (len in 1..n) {
            // Start index of subarray
            for (left in 1..(n - len + 1)) {
                val right = left + len - 1
                // Try each balloon as the last to burst in this range
                for (last in left..right) {
                    val coins = balloons[left - 1] * balloons[last] * balloons[right + 1]
                    val total = coins + dp[left][last - 1] + dp[last + 1][right]
                    dp[left][right] = maxOf(dp[left][right], total)
                }
            }
        }
        
        return dp[1][n]
    }
}