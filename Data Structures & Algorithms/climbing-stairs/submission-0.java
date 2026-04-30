class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) return n;
        
        // Dynamic programming approach
        int first = 1;  // ways to reach step 1
        int second = 2; // ways to reach step 2
        int current = 0;
        
        // Calculate for steps 3 to n
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        
        return second;
    }
}