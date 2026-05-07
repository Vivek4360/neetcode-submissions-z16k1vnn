class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) {
            return ""
        }
        
        var start = 0
        var end = 0
        
        for (i in s.indices) {
            // Check for odd-length palindromes (single character center)
            val len1 = expandAroundCenter(s, i, i)
            // Check for even-length palindromes (two character center)
            val len2 = expandAroundCenter(s, i, i + 1)
            
            // Get the maximum length palindrome centered at position i
            val len = maxOf(len1, len2)
            
            // Update the start and end indices if we found a longer palindrome
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        
        return s.substring(start, end + 1)
    }
    
    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        
        // Return the length of the palindrome
        return r - l - 1
    }
}