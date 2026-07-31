class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val res = mutableListOf<String>()

        for (i in words.indices) {
            for (j in words.indices) {
                if (i == j) {
                    continue
                }

                if (words[j].contains(words[i])) {
                    res.add(words[i])
                    break
                }
            }
        }

        return res
    }
}