class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        // Build adjacency list with PriorityQueue for lexicographical ordering
        val graph = mutableMapOf<String, PriorityQueue<String>>()
        
        for (ticket in tickets) {
            val from = ticket[0]
            val to = ticket[1]
            
            graph.getOrPut(from) { PriorityQueue() }.offer(to)
        }
        
        val itinerary = mutableListOf<String>()
        
        // DFS helper function
        fun dfs(airport: String) {
            val destinations = graph[airport]
            
            // Visit all destinations from current airport
            while (destinations != null && destinations.isNotEmpty()) {
                val nextAirport = destinations.poll() // Get smallest lexicographically
                dfs(nextAirport)
            }
            
            // Add current airport to the front of the list (post-order)
            itinerary.add(0, airport)
        }
        
        dfs("JFK")
        return itinerary
    }
}