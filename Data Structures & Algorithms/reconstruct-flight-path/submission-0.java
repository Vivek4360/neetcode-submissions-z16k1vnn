class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build adjacency list with PriorityQueue for lexicographical ordering
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        
        List<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        
        return itinerary;
    }
    
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, 
                     List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);
        
        // Visit all destinations from current airport
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll(); // Get smallest lexicographically
            dfs(nextAirport, graph, itinerary);
        }
        
        // Add current airport to the front of the list (post-order)
        itinerary.add(0, airport);
    }
}