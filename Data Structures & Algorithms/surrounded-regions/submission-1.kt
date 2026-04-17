class Solution {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty() || board[0].isEmpty()) return
        
        val m = board.size
        val n = board[0].size
        
        // Mark border-connected 'O's as safe (using 'T')
        // Check first and last row
        for (j in 0 until n) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, m, n)
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j, m, n)
            }
        }
        
        // Check first and last column
        for (i in 0 until m) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, m, n)
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, m, n)
            }
        }
        
        // Convert remaining 'O' to 'X' and 'T' back to 'O'
        for (i in 0 until m) {
            for (j in 0 until n) {
                when (board[i][j]) {
                    'O' -> board[i][j] = 'X'  // Surrounded region
                    'T' -> board[i][j] = 'O'  // Safe region
                }
            }
        }
    }
    
    private fun dfs(board: Array<CharArray>, i: Int, j: Int, m: Int, n: Int) {
        // Check bounds and if current cell is 'O'
        if (i !in 0 until m || j !in 0 until n || board[i][j] != 'O') {
            return
        }
        
        // Mark as safe
        board[i][j] = 'T'
        
        // Explore all 4 directions
        dfs(board, i + 1, j, m, n)
        dfs(board, i - 1, j, m, n)
        dfs(board, i, j + 1, m, n)
        dfs(board, i, j - 1, m, n)
    }
}