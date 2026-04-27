class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        
       
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        int maxTime = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int elevation = curr[2];
            
            
            maxTime = Math.max(maxTime, elevation);
            
            
            if (row == n - 1 && col == n - 1) {
                return maxTime;
            }
            
            
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                
                if (newRow >= 0 && newRow < n && 
                    newCol >= 0 && newCol < n && 
                    !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true;
                    pq.offer(new int[]{newRow, newCol, grid[newRow][newCol]});
                }
            }
        }
        
        return maxTime; 
    }
}