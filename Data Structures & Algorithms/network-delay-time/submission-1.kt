

class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // Step 1: Build graph
        val graph = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (t in times) {
            graph.computeIfAbsent(t[0]) { mutableListOf() }
                .add(Pair(t[1], t[2]))
        }

        // Step 2: Min heap
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })
        pq.add(Pair(0, k))

        // Step 3: Distance array
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        dist[k] = 0

        // Step 4: Dijkstra
        while (pq.isNotEmpty()) {
            val (time, node) = pq.poll()

            if (time > dist[node]) continue

            for ((next, t) in graph.getOrDefault(node, mutableListOf())) {
                if (time + t < dist[next]) {
                    dist[next] = time + t
                    pq.add(Pair(dist[next], next))
                }
            }
        }

        // Step 5: Result
        var max = 0
        for (i in 1..n) {
            if (dist[i] == Int.MAX_VALUE) return -1
            max = maxOf(max, dist[i])
        }

        return max
    }
}