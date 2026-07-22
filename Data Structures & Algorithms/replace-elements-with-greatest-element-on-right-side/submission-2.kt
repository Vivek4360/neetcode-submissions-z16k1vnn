class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val n = arr.size
        val ans = IntArray(n)
        for (i in 0 until n) {
            var rightMax = -1
            for (j in i + 1 until n) {
                rightMax = maxOf(rightMax, arr[j])
            }
            ans[i] = rightMax
        }
        return ans
    }
}