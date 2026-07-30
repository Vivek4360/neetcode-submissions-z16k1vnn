class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        for (n in 0 until numRows) {
            val row = mutableListOf(1)
            var value = 1
            for (k in 1..n) {
                value = value * (n - k + 1) / k
                row.add(value)
            }
            res.add(row)
        }
        return res
    }
}