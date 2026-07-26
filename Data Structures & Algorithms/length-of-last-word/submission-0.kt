class Solution {
    fun lengthOfLastWord(s: String): Int {
        var length = 0
        var i = 0
        while (i < s.length) {
            if (s[i] == ' ') {
                while (i < s.length && s[i] == ' ') i++
                if (i == s.length) return length
                length = 0
            } else {
                length++
                i++
            }
        }
        return length
    }
}