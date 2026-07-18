class Solution {
    fun reverseBits(n: Int): Int {
        var num = n
        var result = 0

        repeat(32) {
            result = result shl 1
            result = result or (num and 1)
            num = num ushr 1
        }

        return result
    }
}