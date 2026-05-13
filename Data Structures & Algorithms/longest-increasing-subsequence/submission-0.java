class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        // dp[i] represents the length of LIS ending at index i
        int[] dp = new int[n];
        
        // Initialize each position with 1 (element itself)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        int maxLen = 1;
        
        // For each position, look back at previous positions
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If current element is greater than previous element
                if (nums[i] > nums[j]) {
                    // Update LIS ending at i
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}