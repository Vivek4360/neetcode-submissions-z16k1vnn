class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(nums, target, 0, mutableListOf(), result)
        return result
    }

    private fun backtrack(
        nums: IntArray,
        target: Int,
        start: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            result.add(ArrayList(current))
            return
        }

        if (target < 0) return

        for (i in start until nums.size) {
            current.add(nums[i])
            backtrack(nums, target - nums[i], i, current, result) // reuse same index
            current.removeAt(current.size - 1)
        }
    }
}