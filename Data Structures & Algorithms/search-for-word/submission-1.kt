class Solution {
    
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(board, word, i, j, 0)) return true
            }
        }
        return false
    }

    private fun dfs(
        board: Array<CharArray>,
        word: String,
        i: Int,
        j: Int,
        index: Int
    ): Boolean {
        if (index == word.length) return true

        if (i !in board.indices || j !in board[0].indices ||
            board[i][j] != word[index]
        ) return false

        val temp = board[i][j]
        board[i][j] = '#'

        val found = dfs(board, word, i + 1, j, index + 1) ||
                    dfs(board, word, i - 1, j, index + 1) ||
                    dfs(board, word, i, j + 1, index + 1) ||
                    dfs(board, word, i, j - 1, index + 1)

        board[i][j] = temp

        return found
    }
}