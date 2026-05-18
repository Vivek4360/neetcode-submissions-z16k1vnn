class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If target is impossible to reach or sum + target is odd
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        
        // We need to find a subset with sum = (sum + target) / 2
        int subsetSum = (sum + target) / 2;
        
        // DP array where dp[i] = number of ways to get sum i
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // One way to get sum 0 (empty subset)
        
        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[subsetSum];
    }
}