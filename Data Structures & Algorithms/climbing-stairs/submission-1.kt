class Solution {
    fun climbStairs(n: Int): Int {
        // Base cases
        if (n <= 2) return n
        
        // Dynamic programming approach
        var first = 1   // ways to reach step 1
        var second = 2  // ways to reach step 2
        
        // Calculate for steps 3 to n
        for (i in 3..n) {
            val current = first + second
            first = second
            second = current
        }
        
        return second
    }
}