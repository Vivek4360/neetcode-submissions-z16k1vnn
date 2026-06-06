class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        
        // Sort intervals by end time
        intervals.sortBy { it[1] }
        
        var count = 0
        var prevEnd = intervals[0][1]
        
        // Start from the second interval
        for (i in 1 until intervals.size) {
            // If current interval starts before previous ends, they overlap
            if (intervals[i][0] < prevEnd) {
                count++
            } else {
                // No overlap, update prevEnd
                prevEnd = intervals[i][1]
            }
        }
        
        return count
    }
}