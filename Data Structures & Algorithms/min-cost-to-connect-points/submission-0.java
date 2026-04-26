class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // Create all possible edges with their manhattan distances
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                          Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }
        }
        
        // Sort edges by distance
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        // Union-Find data structure
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int minCost = 0;
        int edgesUsed = 0;
        
        for (int[] edge : edges) {
            if (edgesUsed == n - 1) break;
            
            int point1 = edge[0];
            int point2 = edge[1];
            int cost = edge[2];
            
            if (find(parent, point1) != find(parent, point2)) {
                union(parent, point1, point2);
                minCost += cost;
                edgesUsed++;
            }
        }
        
        return minCost;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // Path compression
        }
        return parent[x];
    }
    
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}