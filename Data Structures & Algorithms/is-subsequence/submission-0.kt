class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        fun rec(i: Int, j: Int): Boolean {
            if (i == s.length) return true
            if (j == t.length) return false
            return if (s[i] == t[j]) {
                rec(i + 1, j + 1)
            } else {
                rec(i, j + 1)
            }
        }
        return rec(0, 0)
    }
}