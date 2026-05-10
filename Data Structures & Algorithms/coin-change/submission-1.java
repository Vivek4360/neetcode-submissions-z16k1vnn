class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] represents the minimum coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Initialize with a value greater than any possible answer
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;
        
        // For each amount from 1 to target amount
        for (int i = 1; i <= amount; i++) {
            // Try each coin denomination
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it's impossible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}