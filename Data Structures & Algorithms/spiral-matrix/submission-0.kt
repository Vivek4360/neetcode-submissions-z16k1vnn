class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val result = mutableListOf<Int>()

        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (i in left..right)
                result.add(matrix[top][i])
            top++

            // Top -> Bottom
            for (i in top..bottom)
                result.add(matrix[i][right])
            right--

            // Right -> Left
            if (top <= bottom) {
                for (i in right downTo left)
                    result.add(matrix[bottom][i])
                bottom--
            }

            // Bottom -> Top
            if (left <= right) {
                for (i in bottom downTo top)
                    result.add(matrix[i][left])
                left++
            }
        }

        return result
    }
}