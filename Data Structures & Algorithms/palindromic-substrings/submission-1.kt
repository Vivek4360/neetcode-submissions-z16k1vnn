class Solution {
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        
        var count = 0
        val n = s.length
        
        // Iterate through each character as potential center
        for (center in 0 until n) {
            // Count odd-length palindromes (single character center)
            count += expandAroundCenter(s, center, center)
            
            // Count even-length palindromes (between two characters)
            count += expandAroundCenter(s, center, center + 1)
        }
        
        return count
    }
    
    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        var count = 0
        
        // Expand outward while characters match and bounds are valid
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            count++    // Found a palindrome
            l--        // Move left pointer outward
            r++        // Move right pointer outward
        }
        
        return count
    }
}