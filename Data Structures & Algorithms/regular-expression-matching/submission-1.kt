class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val m = s.length
        val n = p.length
        
        // dp[i][j] = s[0..i) matches p[0..j)
        val dp = Array(m + 1) { BooleanArray(n + 1) }
        
        // Empty string matches empty pattern
        dp[0][0] = true
        
        // Handle patterns like a*, a*b*, etc. with empty string
        // For even positions (0-indexed), '*' can match zero occurrences
        for (j in 1..n) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2]  // Match zero of the preceding element
            }
        }
        
        // Fill the DP table
        for (i in 1..m) {
            for (j in 1..n) {
                val sc = s[i - 1]
                val pc = p[j - 1]
                
                if (pc == '.' || pc == sc) {
                    // Current characters match
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (pc == '*') {
                    // Two cases for '*':
                    // 1. Skip the pattern (match zero occurrences)
                    dp[i][j] = dp[i][j - 2]
                    
                    // 2. Use the '*' to match current character
                    // Only if the preceding pattern char matches
                    val prevPc = p[j - 2]
                    if (prevPc == '.' || prevPc == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]
                    }
                }
                // else: characters don't match → false (default)
            }
        }
        
        return dp[m][n]
    }
}