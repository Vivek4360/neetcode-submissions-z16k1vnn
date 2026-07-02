class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        // Sort intervals by left endpoint
        intervals.sortBy { it[0] }
        
        // Create array of queries with original indices
        val queryWithIndex = Array(queries.size) { i -> Pair(queries[i], i) }
        queryWithIndex.sortBy { it.first }
        
        // Result array
        val result = IntArray(queries.size) { -1 }
        
        // Min-heap: stores pairs of (length, rightEndpoint)
        // We use length as the primary key for shortest interval
        val heap = java.util.PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        
        var intervalIndex = 0
        
        for ((query, originalIndex) in queryWithIndex) {
            // Add all intervals whose left <= query
            while (intervalIndex < intervals.size && intervals[intervalIndex][0] <= query) {
                val interval = intervals[intervalIndex]
                val length = interval[1] - interval[0] + 1
                heap.offer(Pair(length, interval[1]))
                intervalIndex++
            }
            
            // Remove intervals whose right < query (they don't contain the query)
            while (heap.isNotEmpty() && heap.peek().second < query) {
                heap.poll()
            }
            
            // The top of the heap is the shortest interval containing the query
            if (heap.isNotEmpty()) {
                result[originalIndex] = heap.peek().first
            }
        }
        
        return result
    }
}