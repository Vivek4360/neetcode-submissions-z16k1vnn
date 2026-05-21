class Solution {
    private val directions = arrayOf(
        intArrayOf(0, 1), intArrayOf(1, 0), 
        intArrayOf(0, -1), intArrayOf(-1, 0)
    )
    private lateinit var memo: Array<IntArray>
    
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        
        val m = matrix.size
        val n = matrix[0].size
        memo = Array(m) { IntArray(n) }
        var maxPath = 0
        
        for (i in 0 until m) {
            for (j in 0 until n) {
                maxPath = maxOf(maxPath, dfs(matrix, i, j))
            }
        }
        
        return maxPath
    }
    
    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int): Int {
        if (memo[i][j] != 0) return memo[i][j]
        
        var maxLength = 1
        
        for (dir in directions) {
            val newI = i + dir[0]
            val newJ = j + dir[1]
            
            if (newI in matrix.indices && 
                newJ in matrix[0].indices && 
                matrix[newI][newJ] > matrix[i][j]) {
                
                maxLength = maxOf(maxLength, 1 + dfs(matrix, newI, newJ))
            }
        }
        
        memo[i][j] = maxLength
        return maxLength
    }
}