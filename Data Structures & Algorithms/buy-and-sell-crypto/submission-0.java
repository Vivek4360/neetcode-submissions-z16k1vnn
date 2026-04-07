class Solution {
    public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    
    for (int i = 0; i < prices.length; i++) {
        
        // update minimum price
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }
        
        // calculate profit
        int profit = prices[i] - minPrice;
        
        // update maximum profit
        if (profit > maxProfit) {
            maxProfit = profit;
        }
    }
    
    return maxProfit;

        
    }
}
