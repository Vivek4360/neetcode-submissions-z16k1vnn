class Solution {
    fun hammingWeight(n: Int): Int {
        var num = n
        var count = 0

        repeat(32) {
            count += num and 1
            num = num ushr 1
        }

        return count
    }
}