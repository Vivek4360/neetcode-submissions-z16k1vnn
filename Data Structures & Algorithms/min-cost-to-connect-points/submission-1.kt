class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val n = points.size
        // Create all possible edges with their manhattan distances
        val edges = mutableListOf<Triple<Int, Int, Int>>()
        
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val dist = Math.abs(points[i][0] - points[j][0]) + 
                          Math.abs(points[i][1] - points[j][1])
                edges.add(Triple(i, j, dist))
            }
        }
        
        // Sort edges by distance
        edges.sortBy { it.third }
        
        // Union-Find data structure
        val parent = IntArray(n) { it }
        
        var minCost = 0
        var edgesUsed = 0
        
        for ((point1, point2, cost) in edges) {
            if (edgesUsed == n - 1) break
            
            if (find(parent, point1) != find(parent, point2)) {
                union(parent, point1, point2)
                minCost += cost
                edgesUsed++
            }
        }
        
        return minCost
    }
    
    private fun find(parent: IntArray, x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]) // Path compression
        }
        return parent[x]
    }
    
    private fun union(parent: IntArray, x: Int, y: Int) {
        val rootX = find(parent, x)
        val rootY = find(parent, y)
        if (rootX != rootY) {
            parent[rootX] = rootY
        }
    }
}