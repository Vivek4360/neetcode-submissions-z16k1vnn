class Solution {
    fun maxSubArray(nums: IntArray): Int {
        // Initialize both current sum and max sum with first element
        var currentSum = nums[0]
        var maxSum = nums[0]
        
        // Iterate through the rest of the array
        for (i in 1 until nums.size) {
            // Either extend the current subarray or start a new one
            currentSum = maxOf(nums[i], currentSum + nums[i])
            // Update max sum if current sum is larger
            maxSum = maxOf(maxSum, currentSum)
        }
        
        return maxSum
    }
}