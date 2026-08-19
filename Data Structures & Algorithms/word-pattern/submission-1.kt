class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) {
            return false
        }

        val charToWord = HashMap<Char, String>()
        val wordToChar = HashMap<String, Char>()

        for (i in pattern.indices) {
            val c = pattern[i]
            val w = words[i]

            if (charToWord.containsKey(c) && charToWord[c] != w) {
                return false
            }
            if (wordToChar.containsKey(w) && wordToChar[w] != c) {
                return false
            }

            charToWord[c] = w
            wordToChar[w] = c
        }
        return true
    }
}