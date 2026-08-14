class Solution {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        var cnt = k
        for (i in arr.indices) {
            var flag = true
            for (j in arr.indices) {
                if (i == j) continue

                if (arr[i] == arr[j]) {
                    flag = false
                    break
                }
            }

            if (flag) {
                cnt--
                if (cnt == 0) {
                    return arr[i]
                }
            }
        }
        return ""
    }
}