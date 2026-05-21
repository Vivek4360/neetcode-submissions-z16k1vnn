class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] memo;
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int maxPath = 0;
        
        // Start DFS from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j) {
        // Return cached result if already computed
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int maxLength = 1; // Current cell contributes 1 to the path
        
        // Explore all 4 directions
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            
            // Check bounds and strictly increasing condition
            if (newI >= 0 && newI < matrix.length && 
                newJ >= 0 && newJ < matrix[0].length && 
                matrix[newI][newJ] > matrix[i][j]) {
                
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newI, newJ));
            }
        }
        
        // Cache the result
        memo[i][j] = maxLength;
        return maxLength;
    }
}