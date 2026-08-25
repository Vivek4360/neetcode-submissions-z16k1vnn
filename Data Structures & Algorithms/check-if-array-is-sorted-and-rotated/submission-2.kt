class Solution {
    fun check(nums: IntArray): Boolean {
        val n = nums.size
        val sortedNums = nums.clone()
        sortedNums.sort()

        for (i in 0 until n) {
            var match = true
            var idx = 0

            var j = n - i
            while (j < n && match) {
                if (nums[idx] != sortedNums[j]) {
                    match = false
                }
                idx++
                j++
            }

            j = 0
            while (j < n - i && match) {
                if (nums[idx] != sortedNums[j]) {
                    match = false
                }
                idx++
                j++
            }

            if (match) return true
        }

        return false
    }
}