class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // Build adjacency list and in-degree array
        val adj = List(numCourses) { mutableListOf<Int>() }
        val inDegree = IntArray(numCourses)
        
        for ((course, prerequisite) in prerequisites) {
            adj[prerequisite].add(course)
            inDegree[course]++
        }
        
        // Queue for BFS - start with courses having 0 prerequisites
        val queue = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.add(i)
            }
        }
        
        val result = IntArray(numCourses)
        var index = 0
        
        // Process courses
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            result[index++] = current
            
            // Reduce in-degree for neighbors
            for (neighbor in adj[current]) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }
        
        // Check if all courses can be completed
        return if (index == numCourses) result else intArrayOf()
    }
}