class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open parentheses
        int maxOpen = 0; // Maximum possible open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }
            
            // If maxOpen becomes negative, we have too many closing parentheses
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen cannot be negative (we can always treat '*' as empty or '(')
            minOpen = Math.max(minOpen, 0);
        }
        
        // All parentheses must be closed
        return minOpen == 0;
    }
}