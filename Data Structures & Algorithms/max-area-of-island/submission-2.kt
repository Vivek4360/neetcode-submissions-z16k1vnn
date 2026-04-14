class Solution {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {

                if (grid[i][j] == 1) {
                    val area = dfs(grid, i, j)
                    maxArea = maxOf(maxArea, area)
                }
            }
        }

        return maxArea
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int): Int {
        // boundary or water
        if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == 0) {
            return 0
        }

        // mark visited
        grid[i][j] = 0

        var area = 1

        area += dfs(grid, i - 1, j)
        area += dfs(grid, i + 1, j)
        area += dfs(grid, i, j - 1)
        area += dfs(grid, i, j + 1)

        return area
    }
}