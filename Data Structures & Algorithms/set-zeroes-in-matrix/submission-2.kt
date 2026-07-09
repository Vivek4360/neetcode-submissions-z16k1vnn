class Solution {
    fun setZeroes(matrix: Array<IntArray>) {

        val m = matrix.size
        val n = matrix[0].size

        val rows = BooleanArray(m)
        val cols = BooleanArray(n)

        // First Pass
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    rows[i] = true
                    cols[j] = true
                }
            }
        }

        // Second Pass
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}