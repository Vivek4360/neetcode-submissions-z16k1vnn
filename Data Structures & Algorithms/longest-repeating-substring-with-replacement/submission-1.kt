class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var left = 0
        var maxFreq = 0
        var result = 0

        for (right in s.indices) {
            maxFreq = maxOf(maxFreq, ++count[s[right] - 'A'])

            if ((right - left + 1) - maxFreq > k) {
                count[s[left] - 'A']--
                left++
            }

            result = maxOf(result, right - left + 1)
        }

        return result

    }
}
