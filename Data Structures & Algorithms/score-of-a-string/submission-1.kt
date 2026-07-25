class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0

        for (i in 1 until s.length) {
            score += kotlin.math.abs(s[i].code - s[i - 1].code)
        }

        return score
    }
}