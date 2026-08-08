class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        val n = nums.size
        var res = 1

        for (i in 0 until n - 1) {
            var curLen = 1
            for (j in i + 1 until n) {
                if (nums[j] == nums[j - 1] || ((nums[i] < nums[i + 1]) != (nums[j - 1] < nums[j]))) {
                    break
                }
                curLen++
            }
            res = maxOf(res, curLen)
        }

        return res
    }
}