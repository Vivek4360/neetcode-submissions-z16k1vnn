

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        var freshCount = 0
        
        // Step 1: Count fresh fruits and queue rotten ones
        for (i in 0 until m) {
            for (j in 0 until n) {
                when (grid[i][j]) {
                    2 -> queue.offer(i to j)
                    1 -> freshCount++
                }
            }
        }
        
        // If no fresh fruits, return 0
        if (freshCount == 0) return 0
        
        var minutes = 0
        val dirs = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        
        // Step 2: BFS to spread rot
        while (queue.isNotEmpty()) {
            val size = queue.size
            var rottedAny = false
            
            // Process one level (minute)
            repeat(size) {
                val (r, c) = queue.poll()
                
                for ((dr, dc) in dirs) {
                    val nr = r + dr
                    val nc = c + dc
                    
                    // If in bounds and is fresh fruit
                    if (nr in 0 until m && nc in 0 until n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2  // Rot the fruit
                        queue.offer(nr to nc)
                        freshCount--
                        rottedAny = true
                    }
                }
            }
            
            // Only increment minutes if we rotted something this minute
            if (rottedAny) minutes++
        }
        
        // Step 3: Check if all fresh fruits are rotted
        return if (freshCount == 0) minutes else -1
    }
}