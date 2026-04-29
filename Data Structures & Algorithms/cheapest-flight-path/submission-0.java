class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize prices array with infinity
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        // Run Bellman-Ford for k+1 iterations (at most k stops means at most k+1 edges)
        for (int i = 0; i <= k; i++) {
            // Create a temporary array to avoid using updated prices in the same iteration
            int[] tempPrices = Arrays.copyOf(prices, n);
            
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                
                // If we can reach 'from' airport, try to update 'to' airport
                if (prices[from] != Integer.MAX_VALUE) {
                    tempPrices[to] = Math.min(tempPrices[to], prices[from] + price);
                }
            }
            
            prices = tempPrices;
        }
        
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}