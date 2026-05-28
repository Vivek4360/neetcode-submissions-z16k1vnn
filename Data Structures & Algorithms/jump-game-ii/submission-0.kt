class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) return 0
        
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        
        for (i in 0 until nums.size - 1) {
            // Update the farthest we can reach from current position
            farthest = maxOf(farthest, i + nums[i])
            
            // If we've reached the end of current jump range
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
                
                // If we can already reach the end, break
                if (currentEnd >= nums.size - 1) {
                    break
                }
            }
        }
        
        return jumps
    }
}