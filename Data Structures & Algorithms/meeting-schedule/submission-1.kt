class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        if (intervals.size <= 1) {
            return true
        }
        
        // Sort intervals by start time
        val sortedIntervals = intervals.sortedBy { it.start }
        
        // Check for any overlapping intervals
        for (i in 1 until sortedIntervals.size) {
            // If the start of current meeting is before the end of previous meeting
            if (sortedIntervals[i].start < sortedIntervals[i-1].end) {
                return false
            }
        }
        
        return true
    }
}