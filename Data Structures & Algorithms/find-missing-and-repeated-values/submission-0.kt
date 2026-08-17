class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size
        var doubleVal = 0
        var missing = 0

        for (num in 1..n * n) {
            var cnt = 0
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (grid[i][j] == num) {
                        cnt++
                    }
                }
            }

            if (cnt == 2) {
                doubleVal = num
            } else if (cnt == 0) {
                missing = num
            }
        }

        return intArrayOf(doubleVal, missing)
    }
}