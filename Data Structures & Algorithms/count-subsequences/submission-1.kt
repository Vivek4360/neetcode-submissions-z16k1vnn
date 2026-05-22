class Solution {
    fun numDistinct(s: String, t: String): Int {
        val m = s.length
        val n = t.length
        
        // dp[i][j] = ways to form t[0..j-1] from s[0..i-1]
        val dp = Array(m + 1) { IntArray(n + 1) }
        
        // Base case: empty target can be formed in 1 way
        for (i in 0..m) {
            dp[i][0] = 1
        }
        
        // Fill the DP table
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = if (s[i - 1] == t[j - 1]) {
                    // Use current char + Skip current char
                    dp[i - 1][j - 1] + dp[i - 1][j]
                } else {
                    // Skip current char
                    dp[i - 1][j]
                }
            }
        }
        
        return dp[m][n]
    }
}