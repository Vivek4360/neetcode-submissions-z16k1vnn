class Solution {
    fun findLucky(arr: IntArray): Int {
        var res = -1

        for (num in arr) {
            var cnt = 0
            for (a in arr) {
                if (num == a) {
                    cnt++
                }
            }
            if (cnt == num) {
                res = maxOf(res, num)
            }
        }

        return res
    }
}