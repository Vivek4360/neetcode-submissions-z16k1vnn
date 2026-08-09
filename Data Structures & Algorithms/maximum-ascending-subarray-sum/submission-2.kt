class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var res = 0
        for (i in nums.indices) {
            var curSum = nums[i]
            for (j in i + 1 until nums.size) {
                if (nums[j] <= nums[j - 1]) break
                curSum += nums[j]
            }
            res = maxOf(res, curSum)
        }
        return res
    }
}