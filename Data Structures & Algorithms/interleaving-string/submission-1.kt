class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n = s1.length
        val m = s2.length
        
        // Quick length check
        if (n + m != s3.length) {
            return false
        }
        
        // DP table
        val dp = Array(n + 1) { BooleanArray(m + 1) }
        
        // Base case
        dp[0][0] = true
        
        // Initialize first column (using only s1)
        for (i in 1..n) {
            dp[i][0] = dp[i-1][0] && s1[i-1] == s3[i-1]
        }
        
        // Initialize first row (using only s2)
        for (j in 1..m) {
            dp[0][j] = dp[0][j-1] && s2[j-1] == s3[j-1]
        }
        
        // Fill the DP table
        for (i in 1..n) {
            for (j in 1..m) {
                dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) ||
                           (dp[i][j-1] && s2[j-1] == s3[i+j-1])
            }
        }
        
        return dp[n][m]
    }
}