

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Count fresh fruits and queue rotten ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If no fresh fruits, return 0
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Step 2: BFS to spread rot
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedAny = false;
            
            // Process one level (minute)
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                
                // Check all 4 directions
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    
                    // If in bounds and is fresh fruit
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;  // Rot the fruit
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rottedAny = true;
                    }
                }
            }
            
            // Only increment minutes if we rotted something this minute
            if (rottedAny) minutes++;
        }
        
        // Step 3: Check if all fresh fruits are rotted
        return freshCount == 0 ? minutes : -1;
    }
}