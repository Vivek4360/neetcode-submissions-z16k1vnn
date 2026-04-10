class Solution {

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val mapping = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        val result = mutableListOf<String>()
        backtrack(digits, mapping, 0, StringBuilder(), result)
        return result
    }

    private fun backtrack(
        digits: String,
        mapping: Map<Char, String>,
        index: Int,
        current: StringBuilder,
        result: MutableList<String>
    ) {
        if (index == digits.length) {
            result.add(current.toString())
            return
        }

        val letters = mapping[digits[index]]!!

        for (c in letters) {
            current.append(c)
            backtrack(digits, mapping, index + 1, current, result)
            current.deleteCharAt(current.length - 1)
        }
    }
}