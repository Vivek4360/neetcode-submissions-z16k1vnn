class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val n = nums.size
        for (i in 0 until n) {
            var leftSum = 0
            var rightSum = 0
            for (l in 0 until i) {
                leftSum += nums[l]
            }
            for (r in i + 1 until n) {
                rightSum += nums[r]
            }
            if (leftSum == rightSum) {
                return i
            }
        }
        return -1
    }
}