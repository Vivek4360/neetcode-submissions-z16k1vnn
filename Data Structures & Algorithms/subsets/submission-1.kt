class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(0, nums, mutableListOf(), result)
        return result
    }

    private fun backtrack(
        start: Int,
        nums: IntArray,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        // Step 1: Add current subset
        result.add(ArrayList(current))

        // Step 2: Explore choices
        for (i in start until nums.size) {
            // Choose
            current.add(nums[i])

            // Explore
            backtrack(i + 1, nums, current, result)

            // Backtrack (undo)
            current.removeAt(current.size - 1)
        }
    }
}