class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var j = 0

        for (i in s.indices) {
            if (j < t.length && s[i] == t[j]) {
                j++
            }
        }

        return t.length - j
    }
}