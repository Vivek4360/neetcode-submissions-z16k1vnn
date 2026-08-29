class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return listOf(1)

        val curRow = mutableListOf(1)
        val prevRow = getRow(rowIndex - 1)

        for (i in 1 until rowIndex) {
            curRow.add(prevRow[i - 1] + prevRow[i])
        }

        curRow.add(1)
        return curRow
    }
}