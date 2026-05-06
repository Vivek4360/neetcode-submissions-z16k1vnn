class Solution {
    public int rob(int[] nums) {
        // STEP 1: Handle simple cases
        int n = nums.length;
        
        // If no houses, return 0
        if (n == 0) return 0;
        
        // If only 1 house, rob it!
        if (n == 1) return nums[0];
        
        // If 2 houses, rob the richer one
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        // STEP 2: Solve for two different scenarios
        
        // Scenario A: Rob houses 0 to n-2 (skip last house)
        // Example: [3,4,3] → [3,4]
        int money1 = robSimple(nums, 0, n - 2);
        
        // Scenario B: Rob houses 1 to n-1 (skip first house)  
        // Example: [3,4,3] → [4,3]
        int money2 = robSimple(nums, 1, n - 1);
        
        // STEP 3: Return the better option
        return Math.max(money1, money2);
    }
    
    // This solves the simple straight-line robbery problem
    private int robSimple(int[] nums, int start, int end) {
        // We need at least 2 variables to track:
        // - Money if we robbed 2 houses ago
        // - Money if we robbed the previous house
        
        int twoHousesAgo = 0;    // Money from robbing house (i-2)
        int previousHouse = 0;   // Money from robbing house (i-1)
        
        // Go through each house in our range
        for (int i = start; i <= end; i++) {
            // For current house, we have 2 choices:
            // 1. Skip it → take previousHouse money
            // 2. Rob it → take current money + twoHousesAgo money
            
            int skipThisHouse = previousHouse;
            int robThisHouse = nums[i] + twoHousesAgo;
            
            // Take the better choice
            int currentBest = Math.max(skipThisHouse, robThisHouse);
            
            // Update for next iteration
            twoHousesAgo = previousHouse;  // Move forward
            previousHouse = currentBest;    // Store current best
        }
        
        // previousHouse now holds the answer
        return previousHouse;
    }
}