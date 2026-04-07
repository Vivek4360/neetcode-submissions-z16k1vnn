class KthLargest(private val k: Int, nums: IntArray) {

    private val minHeap = PriorityQueue<Int>()

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun add(`val`: Int): Int {
        minHeap.offer(`val`)

        if (minHeap.size > k) {
            minHeap.poll()
        }

        return minHeap.peek()
    }
}
