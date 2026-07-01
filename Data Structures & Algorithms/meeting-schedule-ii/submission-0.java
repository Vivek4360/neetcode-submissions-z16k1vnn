class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        
        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        
        // Extract start and end times
        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }
        
        // Sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int rooms = 0;
        int maxRooms = 0;
        int startPtr = 0;
        int endPtr = 0;
        
        // Two-pointer technique (like merging timelines)
        while (startPtr < n) {
            if (startTimes[startPtr] < endTimes[endPtr]) {
                // A new meeting starts before the earliest ending meeting finishes
                rooms++;
                startPtr++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                // A meeting ended, freeing up a room
                rooms--;
                endPtr++;
            }
        }
        
        return maxRooms;
    }
}