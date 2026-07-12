class Solution {
    fun myPow(x: Double, n: Int): Double {
        var base = x
        var exp = n.toLong()   
        var ans = 1.0

        if (exp < 0) {
            base = 1.0 / base
            exp = -exp
        }

        while (exp > 0) {
            if (exp % 2L == 1L) {
                ans *= base
            }
            base *= base
            exp /= 2
        }

        return ans
    }
}