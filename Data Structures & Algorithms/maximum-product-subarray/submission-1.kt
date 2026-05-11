class Solution {
    fun maxProduct(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        
        var maxSoFar = nums[0]
        var minSoFar = nums[0]
        var result = nums[0]
        
        for (i in 1 until nums.size) {
            val current = nums[i]
            
            
            val tempMax = maxSoFar
            
            
            maxSoFar = maxOf(current, maxOf(maxSoFar * current, minSoFar * current))
            minSoFar = minOf(current, minOf(tempMax * current, minSoFar * current))
            
            
            result = maxOf(result, maxSoFar)
        }
        
        return result
    }
}