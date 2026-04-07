class Solution {
    
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray> { a, b ->
            distance(b) - distance(a)
        }

        for (point in points) {
            maxHeap.offer(point)

            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }

        val result = Array(k) { IntArray(2) }
        var i = 0

        while (maxHeap.isNotEmpty()) {
            result[i++] = maxHeap.poll()
        }

        return result
    }

    private fun distance(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1]
    }
}
