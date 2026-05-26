class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize both current sum and max sum with first element
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Iterate through the rest of the array
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update max sum if current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}