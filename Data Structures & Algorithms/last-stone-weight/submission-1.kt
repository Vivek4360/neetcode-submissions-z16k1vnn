class Solution {
     fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        // Add stones
        for (stone in stones) {
            maxHeap.add(stone)
        }

        // Process
        while (maxHeap.size > 1) {
            val y = maxHeap.poll()
            val x = maxHeap.poll()

            if (y != x) {
                maxHeap.add(y - x)
            }
        }

        return if (maxHeap.isEmpty()) 0 else maxHeap.poll()
    }
}