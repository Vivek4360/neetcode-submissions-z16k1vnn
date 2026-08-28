class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        var res = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) {
                    res++
                }
            }
        }
        return res
    }
}