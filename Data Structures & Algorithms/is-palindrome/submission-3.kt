class Solution {
    fun isPalindrome(s: String): Boolean {
        var newStr = ""
        for (c in s) {
            if (c.isLetterOrDigit()) {
                newStr += c.lowercaseChar()
            }
        }
        return newStr == newStr.reversed()
    }
}