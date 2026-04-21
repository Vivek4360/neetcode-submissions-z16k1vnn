class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Int>() }

        // Build adjacency list
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        val visited = BooleanArray(n)
        var count = 0

        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(graph, visited, i)
                count++
            }
        }

        return count
    }

    private fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, node: Int) {
        visited[node] = true

        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor)
            }
        }
    }
}