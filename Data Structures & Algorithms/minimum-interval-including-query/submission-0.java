class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by left endpoint
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // Create array of queries with original indices
        int[][] queryWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);
        
        // Result array
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        
        // Min-heap: stores arrays of [length, rightEndpoint]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int intervalIndex = 0;
        
        for (int[] q : queryWithIndex) {
            int query = q[0];
            int originalIndex = q[1];
            
            // Add all intervals whose left <= query
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int[] interval = intervals[intervalIndex];
                int length = interval[1] - interval[0] + 1;
                heap.offer(new int[]{length, interval[1]});
                intervalIndex++;
            }
            
            // Remove intervals whose right < query
            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }
            
            // The top of the heap is the shortest interval containing the query
            if (!heap.isEmpty()) {
                result[originalIndex] = heap.peek()[0];
            }
        }
        
        return result;
    }
}