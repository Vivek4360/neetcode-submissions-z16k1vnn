class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        // A tree must have exactly n-1 edges.
        if (edges.size != n - 1) {
            return false
        }

        // Build the graph (using adjacency list)
        val graph = Array(n) { mutableListOf<Int>() }

        // Add edges to the graph (undirected)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            graph[u].add(v)
            graph[v].add(u)
        }

        // Keep track of visited nodes
        val visited = BooleanArray(n)

        // Perform DFS starting from node 0
        if (hasCycle(graph, 0, visited, -1)) {
            return false // Cycle detected
        }

        // Check if all nodes were visited (the graph is connected)
        for (v in visited) {
            if (!v) {
                return false // Not all nodes are connected
            }
        }

        return true // It's a valid tree
    }

    private fun hasCycle(graph: Array<MutableList<Int>>, node: Int, visited: BooleanArray, parent: Int): Boolean {
        visited[node] = true

        // Traverse the neighbors of the current node
        for (neighbor in graph[node]) {
            // If the neighbor has not been visited, perform DFS recursively
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, node)) {
                    return true // Cycle detected
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, we found a cycle
                return true
            }
        }

        return false // No cycle detected
    }
}