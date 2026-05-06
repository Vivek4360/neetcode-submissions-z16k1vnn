class Solution {
    fun rob(nums: IntArray): Int = when (nums.size) {
        0 -> 0
        1 -> nums[0]
        2 -> maxOf(nums[0], nums[1])
        else -> maxOf(
            nums.robRange(0, nums.size - 2),
            nums.robRange(1, nums.size - 1)
        )
    }
    
    private fun IntArray.robRange(start: Int, end: Int): Int {
        var (prev2, prev1) = 0 to 0
        
        for (i in start..end) {
            val current = maxOf(prev1, prev2 + this[i])
            prev2 = prev1
            prev1 = current
        }
        
        return prev1
    }
}