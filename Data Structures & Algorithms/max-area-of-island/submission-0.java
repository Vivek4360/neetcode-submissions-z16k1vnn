class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        // boundary or water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // mark visited
        grid[i][j] = 0;

        // count area
        int area = 1;

        area += dfs(grid, i - 1, j); // up
        area += dfs(grid, i + 1, j); // down
        area += dfs(grid, i, j - 1); // left
        area += dfs(grid, i, j + 1); // right

        return area;
    }
}