class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) { mutableListOf<Int>() }
        val indegree = IntArray(numCourses)

        // Build graph
        for (p in prerequisites) {
            val a = p[0]
            val b = p[1]
            graph[b].add(a)
            indegree[a]++
        }

        val queue: ArrayDeque<Int> = ArrayDeque()

        // Add indegree 0 nodes
        for (i in 0 until numCourses) {
            if (indegree[i] == 0) {
                queue.add(i)
            }
        }

        var count = 0

        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            count++

            for (neighbor in graph[course]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        return count == numCourses
    }
}