class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        val n = nums.size
        var increase = true
        for (i in 1 until n) {
            if (nums[i] < nums[i - 1]) {
                increase = false
                break
            }
        }
        if (increase) {
            return true
        }

        var decrease = true
        for (i in 1 until n) {
            if (nums[i] > nums[i - 1]) {
                decrease = false
                break
            }
        }
        return decrease
    }
}