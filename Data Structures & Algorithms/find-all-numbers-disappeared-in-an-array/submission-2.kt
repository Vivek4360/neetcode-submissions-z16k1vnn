class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        val mark = BooleanArray(n)

        for (num in nums) {
            mark[num - 1] = true
        }

        val res = mutableListOf<Int>()
        for (i in 1..n) {
            if (!mark[i - 1]) {
                res.add(i)
            }
        }
        return res
    }
}