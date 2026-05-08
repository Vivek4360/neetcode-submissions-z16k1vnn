class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int n = s.length();
        
        // Iterate through each character as potential center
        for (int center = 0; center < n; center++) {
            // Count odd-length palindromes (single character center)
            count += expandAroundCenter(s, center, center);
            
            // Count even-length palindromes (between two characters)
            count += expandAroundCenter(s, center, center + 1);
        }
        
        return count;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        
        // Expand outward while characters match and bounds are valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;    // Found a palindrome
            left--;     // Move left pointer outward
            right++;    // Move right pointer outward
        }
        
        return count;
    }
}