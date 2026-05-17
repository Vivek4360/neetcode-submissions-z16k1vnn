class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] represents the number of combinations to make amount i
        int[] dp = new int[amount + 1];
        
        // Base case: there's 1 way to make amount 0 (using no coins)
        dp[0] = 1;
        
        // For each coin, update the dp array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
    }
}