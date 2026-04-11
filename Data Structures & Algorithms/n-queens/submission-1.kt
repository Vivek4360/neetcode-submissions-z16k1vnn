class Solution {
    fun solveNQueens(n: Int): List<List<String>> {

        
        val result = mutableListOf<List<String>>()

        val cols = mutableSetOf<Int>()
        val diag1 = mutableSetOf<Int>()
        val diag2 = mutableSetOf<Int>()

        val board = Array(n) { CharArray(n) { '.' } }

        backtrack(0, n, board, result, cols, diag1, diag2)
        return result
    }

    private fun backtrack(
        row: Int,
        n: Int,
        board: Array<CharArray>,
        result: MutableList<List<String>>,
        cols: MutableSet<Int>,
        diag1: MutableSet<Int>,
        diag2: MutableSet<Int>
    ) {
        if (row == n) {
            result.add(board.map { String(it) })
            return
        }

        for (col in 0 until n) {

            if (col in cols || (row - col) in diag1 || (row + col) in diag2) {
                continue
            }

            // Place
            board[row][col] = 'Q'
            cols.add(col)
            diag1.add(row - col)
            diag2.add(row + col)

            backtrack(row + 1, n, board, result, cols, diag1, diag2)

            // Backtrack
            board[row][col] = '.'
            cols.remove(col)
            diag1.remove(row - col)
            diag2.remove(row + col)
        }
    }
}

    
