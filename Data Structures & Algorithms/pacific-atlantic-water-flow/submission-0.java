class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific edges (top and left)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0, m, n); // Left edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j, m, n); // Top edge
        }
        
        // DFS from Atlantic edges (bottom and right)
        for (int i = 0; i < m; i++) {
            dfs(heights, atlantic, i, n - 1, m, n); // Right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlantic, m - 1, j, m, n); // Bottom edge
        }
        
        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int m, int n) {
        visited[r][c] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            
            // Check bounds and if already visited
            if (newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC]) {
                continue;
            }
            
            // Important: We're going backwards, so we can only move to higher or equal heights
            if (heights[newR][newC] >= heights[r][c]) {
                dfs(heights, visited, newR, newC, m, n);
            }
        }
    }
}