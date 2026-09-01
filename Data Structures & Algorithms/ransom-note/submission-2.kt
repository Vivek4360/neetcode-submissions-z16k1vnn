class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val mag = magazine.toMutableList()

        for (c in ransomNote) {
            if (!mag.contains(c)) return false
            mag.remove(c)
        }

        return true
    }
}