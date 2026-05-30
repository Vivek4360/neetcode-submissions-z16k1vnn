class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        // Count frequencies
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        
        // Sort the unique cards
        int[] uniqueCards = countMap.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(uniqueCards);
        
        // Process each card from smallest to largest
        for (int card : uniqueCards) {
            int count = countMap.get(card);
            
            if (count > 0) {
                // Try to form groups starting from this card
                for (int i = groupSize - 1; i >= 0; i--) {
                    int currentCard = card + i;
                    int currentCount = countMap.getOrDefault(currentCard, 0);
                    
                    if (currentCount < count) {
                        return false;
                    }
                    
                    countMap.put(currentCard, currentCount - count);
                }
            }
        }
        
        return true;
    }
}