class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        
        // Create DP table
        val dp = Array(m + 1) { IntArray(n + 1) }
        
        // Base cases
        for (i in 0..m) {
            dp[i][0] = i  // Delete all characters from word1
        }
        for (j in 0..n) {
            dp[0][j] = j  // Insert all characters to word1
        }
        
        // Fill the DP table
        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(
                        dp[i - 1][j],     // Delete
                        dp[i][j - 1],     // Insert
                        dp[i - 1][j - 1]  // Replace
                    )
                }
            }
        }
        
        return dp[m][n]
    }
}