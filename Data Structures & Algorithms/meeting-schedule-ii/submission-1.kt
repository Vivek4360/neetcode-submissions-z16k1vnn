class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        
        val n = intervals.size
        val startTimes = IntArray(n) { intervals[it].start }
        val endTimes = IntArray(n) { intervals[it].end }
        
        // Sort both arrays
        startTimes.sort()
        endTimes.sort()
        
        var rooms = 0
        var maxRooms = 0
        var startPtr = 0
        var endPtr = 0
        
        // Two-pointer technique
        while (startPtr < n) {
            if (startTimes[startPtr] < endTimes[endPtr]) {
                // A new meeting starts before the earliest ending meeting finishes
                rooms++
                startPtr++
                maxRooms = maxOf(maxRooms, rooms)
            } else {
                // A meeting ended, freeing up a room
                rooms--
                endPtr++
            }
        }
        
        return maxRooms
    }
}