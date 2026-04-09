class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val part = mutableListOf<String>()

        fun dfs(j: Int, i: Int) {
            if (i >= s.length) {
                if (i == j) {
                    res.add(part.toList())
                }
                return
            }

            if (isPali(s, j, i)) {
                part.add(s.substring(j, i + 1))
                dfs(i + 1, i + 1)
                part.removeAt(part.size - 1)
            }

            dfs(j, i + 1)
        }

        dfs(0, 0)
        return res
    }

    private fun isPali(s: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}