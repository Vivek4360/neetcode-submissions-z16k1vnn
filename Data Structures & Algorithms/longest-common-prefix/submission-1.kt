class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs[0]
        for (i in 1 until strs.size) {
            var j = 0
            while (j < minOf(prefix.length, strs[i].length)) {
                if (prefix[j] != strs[i][j]) {
                    break
                }
                j++
            }
            prefix = prefix.substring(0, j)
        }
        return prefix
    }
}