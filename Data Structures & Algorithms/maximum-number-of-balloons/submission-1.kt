class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val count = IntArray(26)

        // Count characters
        for (c in text) {
            count[c - 'a']++
        }

        val b = count['b' - 'a']
        val a = count['a' - 'a']
        val l = count['l' - 'a'] / 2
        val o = count['o' - 'a'] / 2
        val n = count['n' - 'a']

        return minOf(b, a, l, o, n)
    }
}
