class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Add boundary balloons with value 1
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        System.arraycopy(nums, 0, balloons, 1, n);
        
        int[][] dp = new int[n + 2][n + 2];
        
        // Length of subarray to consider
        for (int len = 1; len <= n; len++) {
            // Start index of subarray
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                // Try each balloon as the last to burst in this range
                for (int last = left; last <= right; last++) {
                    int coins = balloons[left - 1] * balloons[last] * balloons[right + 1];
                    coins += dp[left][last - 1] + dp[last + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        
        return dp[1][n];
    }
}