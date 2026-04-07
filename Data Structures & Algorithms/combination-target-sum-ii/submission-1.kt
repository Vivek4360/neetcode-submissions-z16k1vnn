class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        backtrack(candidates, target, 0, mutableListOf(), result)
        return result
    }

    private fun backtrack(
        candidates: IntArray,
        target: Int,
        start: Int,
        temp: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (target == 0) {
            result.add(ArrayList(temp))
            return
        }

        for (i in start until candidates.size) {

            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue

            // Stop if exceeds target
            if (candidates[i] > target) break

            temp.add(candidates[i])
            backtrack(candidates, target - candidates[i], i + 1, temp, result)
            temp.removeAt(temp.size - 1) // backtrack
        }
    }
}