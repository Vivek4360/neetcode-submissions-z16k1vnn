class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val count = mutableMapOf<Char, Int>()
        for (c in chars) {
            count[c] = count.getOrDefault(c, 0) + 1
        }
        var res = 0
        for (w in words) {
            val curWord = mutableMapOf<Char, Int>()
            for (c in w) {
                curWord[c] = curWord.getOrDefault(c, 0) + 1
            }
            var good = true
            for ((c, cnt) in curWord) {
                if (cnt > count.getOrDefault(c, 0)) {
                    good = false
                    break
                }
            }
            if (good) {
                res += w.length
            }
        }
        return res
    }
}