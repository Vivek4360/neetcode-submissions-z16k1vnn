class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n = nums.size

        val expected = n * (n + 1) / 2

        var actual = 0

        for (num in nums) {
            actual += num
        }

        return expected - actual
    }
}
