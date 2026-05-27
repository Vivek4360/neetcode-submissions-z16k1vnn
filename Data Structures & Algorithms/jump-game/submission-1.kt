class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxReach = 0
        
        for (i in nums.indices) {
            // If current index is beyond our maximum reach, we can't proceed
            if (i > maxReach) {
                return false
            }
            
            // Update the maximum index we can reach
            maxReach = maxOf(maxReach, i + nums[i])
            
            // If we can already reach the last index, return true
            if (maxReach >= nums.size - 1) {
                return true
            }
        }
        
        return true
    }
}