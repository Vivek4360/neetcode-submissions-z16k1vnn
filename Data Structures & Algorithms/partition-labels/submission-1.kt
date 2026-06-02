class Solution {
    fun partitionLabels(s: String): List<Int> {
        val result = mutableListOf<Int>()
        
        // Store the last occurrence index of each character
        val lastOccurrence = IntArray(26)
        for (i in s.indices) {
            lastOccurrence[s[i] - 'a'] = i
        }
        
        var start = 0
        var end = 0
        
        // Iterate through the string
        for (i in s.indices) {
            // Update the end to the furthest last occurrence of current characters
            end = maxOf(end, lastOccurrence[s[i] - 'a'])
            
            // If we've reached the end of the current partition
            if (i == end) {
                result.add(end - start + 1)
                start = i + 1
            }
        }
        
        return result
    }
}