class Solution {
    fun divideArray(nums: IntArray): Boolean {
        val N = nums.size
        nums.sort()

        var i = 0
        while (i < N) {
            var j = i
            while (j < N && nums[i] == nums[j]) {
                j++
            }

            if ((j - i) % 2 != 0) {
                return false
            }

            i = j
        }

        return true
    }
}