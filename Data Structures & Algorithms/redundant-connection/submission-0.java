class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Step 1: Initialize parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Step 2: Process edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            // Cycle detected
            if (parentU == parentV) {
                return edge;
            }

            // Union
            parent[parentU] = parentV;
        }

        return new int[0];
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node];
    }
}