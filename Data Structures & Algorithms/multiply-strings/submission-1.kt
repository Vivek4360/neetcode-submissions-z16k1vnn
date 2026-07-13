class Solution {
    fun multiply(num1: String, num2: String): String {

        if (num1 == "0" || num2 == "0") return "0"

        val m = num1.length
        val n = num2.length

        val res = IntArray(m + n)

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {

                val mul = (num1[i] - '0') * (num2[j] - '0')

                val p1 = i + j
                val p2 = i + j + 1

                val sum = mul + res[p2]

                res[p2] = sum % 10
                res[p1] += sum / 10
            }
        }

        val sb = StringBuilder()

        for (x in res) {
            if (!(sb.isEmpty() && x == 0))
                sb.append(x)
        }

        return sb.toString()
    }
}