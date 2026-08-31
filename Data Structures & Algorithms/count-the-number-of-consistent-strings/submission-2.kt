class Solution {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        var res = 0

        for (w in words) {
            var flag = true
            for (c in w) {
                if (c !in allowed) {
                    flag = false
                    break
                }
            }
            if (flag) res++
        }

        return res
    }
}