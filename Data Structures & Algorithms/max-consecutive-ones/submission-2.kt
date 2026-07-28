class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        val n = nums.size
        var res = 0
        for (i in 0 until n) {
            var cnt = 0
            for (j in i until n) {
                if (nums[j] == 0) break
                cnt++
            }
            res = maxOf(res, cnt)
        }
        return res
    }
}