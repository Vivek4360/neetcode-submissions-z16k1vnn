class Solution {
    fun checkValidString(s: String): Boolean {
        var minOpen = 0 // Minimum possible open parentheses
        var maxOpen = 0 // Maximum possible open parentheses
        
        for (c in s) {
            when (c) {
                '(' -> {
                    minOpen++
                    maxOpen++
                }
                ')' -> {
                    minOpen--
                    maxOpen--
                }
                '*' -> {
                    minOpen-- // Treat '*' as ')'
                    maxOpen++ // Treat '*' as '('
                }
            }
            
            // If maxOpen becomes negative, we have too many closing parentheses
            if (maxOpen < 0) {
                return false
            }
            
            // minOpen cannot be negative (we can always treat '*' as empty or '(')
            minOpen = maxOf(minOpen, 0)
        }
        
        // All parentheses must be closed
        return minOpen == 0
    }
}