class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }
        
        // Sort intervals by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        // Check for any overlapping intervals
        for (int i = 1; i < intervals.size(); i++) {
            // If the start of current meeting is before the end of previous meeting
            if (intervals.get(i).start < intervals.get(i-1).end) {
                return false;
            }
        }
        
        return true;
    }
}