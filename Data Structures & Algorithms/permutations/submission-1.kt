class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(result, mutableListOf(), nums)
        return result
    }

    private fun backtrack(
        result: MutableList<List<Int>>,
        temp: MutableList<Int>,
        nums: IntArray
    ) {
        if (temp.size == nums.size) {
            result.add(ArrayList(temp))
            return
        }

        for (num in nums) {
            if (temp.contains(num)) continue

            temp.add(num)
            backtrack(result, temp, nums)
            temp.removeAt(temp.size - 1)
        }
    }
}