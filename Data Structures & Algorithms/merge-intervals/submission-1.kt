class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }
        
        // Sort intervals by start time
        intervals.sortBy { it[0] }
        
        val result = mutableListOf<IntArray>()
        var currentInterval = intervals[0]
        result.add(currentInterval)
        
        for (i in 1 until intervals.size) {
            val interval = intervals[i]
            val currentEnd = currentInterval[1]
            val nextStart = interval[0]
            val nextEnd = interval[1]
            
            // If intervals overlap, merge them
            if (nextStart <= currentEnd) {
                currentInterval[1] = maxOf(currentEnd, nextEnd)
            } else {
                // No overlap, add new interval
                currentInterval = interval
                result.add(currentInterval)
            }
        }
        
        return result.toTypedArray()
    }
}