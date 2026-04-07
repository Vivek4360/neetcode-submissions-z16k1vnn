class MedianFinder {

    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

    private val minHeap = PriorityQueue<Int>()

    fun addNum(num: Int) {

        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        if (maxHeap.size > minHeap.size + 1) {
            minHeap.offer(maxHeap.poll()) 
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(minHeap.poll()) 
        }


    }

    fun findMedian(): Double {

        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            maxHeap.peek().toDouble() 
        }

    }
}
