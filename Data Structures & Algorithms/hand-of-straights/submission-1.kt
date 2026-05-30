class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        // If total cards can't be divided evenly, return false
        if (hand.size % groupSize != 0) {
            return false
        }
        
        // Count frequency of each card using TreeMap (keeps keys sorted)
        val cardCount = java.util.TreeMap<Int, Int>()
        for (card in hand) {
            cardCount[card] = cardCount.getOrDefault(card, 0) + 1
        }
        
        // Process groups starting from smallest card
        while (cardCount.isNotEmpty()) {
            val startCard = cardCount.firstKey()
            
            // Try to form a group starting from startCard
            for (i in 0 until groupSize) {
                val currentCard = startCard + i
                
                // If current card doesn't exist, can't form group
                if (!cardCount.containsKey(currentCard)) {
                    return false
                }
                
                // Decrease count of current card
                val count = cardCount[currentCard]!!
                if (count == 1) {
                    cardCount.remove(currentCard)
                } else {
                    cardCount[currentCard] = count - 1
                }
            }
        }
        
        return true
    }
}