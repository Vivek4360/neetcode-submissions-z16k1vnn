class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        if (heights.isEmpty() || heights[0].isEmpty()) return emptyList()
        
        val m = heights.size
        val n = heights[0].size
        
        val pacific = Array(m) { BooleanArray(n) }
        val atlantic = Array(m) { BooleanArray(n) }
        
        // DFS from Pacific edges
        for (i in 0 until m) {
            dfs(heights, pacific, i, 0, m, n)
        }
        for (j in 0 until n) {
            dfs(heights, pacific, 0, j, m, n)
        }
        
        // DFS from Atlantic edges
        for (i in 0 until m) {
            dfs(heights, atlantic, i, n - 1, m, n)
        }
        for (j in 0 until n) {
            dfs(heights, atlantic, m - 1, j, m, n)
        }
        
        // Find intersection
        val result = mutableListOf<List<Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }
        
        return result
    }
    
    private fun dfs(
        heights: Array<IntArray>, 
        visited: Array<BooleanArray>, 
        r: Int, 
        c: Int, 
        m: Int, 
        n: Int
    ) {
        visited[r][c] = true
        
        val directions = arrayOf(
            intArrayOf(-1, 0), // up
            intArrayOf(1, 0),  // down
            intArrayOf(0, -1), // left
            intArrayOf(0, 1)   // right
        )
        
        for (dir in directions) {
            val newR = r + dir[0]
            val newC = c + dir[1]
            
            if (newR !in 0 until m || newC !in 0 until n || visited[newR][newC]) {
                continue
            }
            
            // Move to higher or equal heights (backwards flow)
            if (heights[newR][newC] >= heights[r][c]) {
                dfs(heights, visited, newR, newC, m, n)
            }
        }
    }
}