class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort() // step 1: sort
        val result = mutableListOf<List<Int>>()
        backtrack(nums, 0, mutableListOf(), result)
        return result
    }

    fun backtrack(
        nums: IntArray,
        start: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        result.add(ArrayList(current)) // save

        for (i in start until nums.size) {

            // skip duplicate
            if (i > start && nums[i] == nums[i - 1]) continue

            current.add(nums[i])                 // take
            backtrack(nums, i + 1, current, result) // go
            current.removeAt(current.size - 1)   // remove
        }
    }
}
