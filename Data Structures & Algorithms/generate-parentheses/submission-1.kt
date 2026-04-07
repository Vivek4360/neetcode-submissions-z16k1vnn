class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        backtrack(result, "", 0, 0, n)
        return result
    }

    private fun backtrack(
        result: MutableList<String>,
        current: String,
        open: Int,
        close: Int,
        n: Int
    ) {
        // base case
        if (current.length == 2 * n) {
            result.add(current)
            return
        }

        // add '('
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n)
        }

        // add ')'
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n)
        }
    }
}