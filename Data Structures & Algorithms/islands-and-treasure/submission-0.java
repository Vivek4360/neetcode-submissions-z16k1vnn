class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Add all treasure chests to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        // Directions: up, down, left, right
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Step 2: BFS from all treasures
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // If out of bounds or not an unvisited land cell, skip
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                
                // Update distance and add to queue
                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
    