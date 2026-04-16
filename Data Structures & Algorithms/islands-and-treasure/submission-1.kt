class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {

        val m = grid.size
    val n = grid[0].size
    val q: Queue<Pair<Int, Int>> = LinkedList()
    
    // Add all treasures
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 0) {
                q.offer(i to j)
            }
        }
    }
    
    val dirs = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    
    while (q.isNotEmpty()) {
        val (r, c) = q.poll()
        
        for ((dr, dc) in dirs) {
            val nr = r + dr
            val nc = c + dc
            
            if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == Int.MAX_VALUE) {
                grid[nr][nc] = grid[r][c] + 1
                q.offer(nr to nc)
            }
        }
    }
    }
}

  
