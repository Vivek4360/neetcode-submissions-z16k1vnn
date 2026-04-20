class Solution {
    public boolean validTree(int n, int[][] edges) {
        // A tree must have exactly n-1 edges.
        if (edges.length != n - 1) {
            return false;
        }

        // Build the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Perform DFS starting from node 0
        if (hasCycle(graph, 0, visited, -1)) {
            return false; // Cycle detected
        }

        // Check if all nodes were visited (the graph is connected)
        for (boolean v : visited) {
            if (!v) {
                return false; // Not all nodes are connected
            }
        }

        return true; // It's a valid tree
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, boolean[] visited, int parent) {
        visited[node] = true;

        // Traverse the neighbors of the current node
        for (int neighbor : graph.get(node)) {
            // If the neighbor has not been visited, perform DFS recursively
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, node)) {
                    return true; // Cycle detected
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, we found a cycle
                return true;
            }
        }

        return false; // No cycle detected
    }
}