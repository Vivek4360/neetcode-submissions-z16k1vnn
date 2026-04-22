class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parent = IntArray(n + 1) { it }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            val parentU = find(parent, u)
            val parentV = find(parent, v)

            // Cycle found
            if (parentU == parentV) {
                return edge
            }

            // Union
            parent[parentU] = parentV
        }

        return intArrayOf()
    }

    private fun find(parent: IntArray, node: Int): Int {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]) // Path compression
        }
        return parent[node]
    }
}