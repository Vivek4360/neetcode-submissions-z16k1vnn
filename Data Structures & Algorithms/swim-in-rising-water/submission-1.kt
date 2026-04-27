class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        
        
        val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
        val visited = Array(n) { BooleanArray(n) }
        
        
        val dirs = arrayOf(
            intArrayOf(0, 1), 
            intArrayOf(1, 0), 
            intArrayOf(0, -1), 
            intArrayOf(-1, 0)
        )
        
        
        pq.offer(Triple(0, 0, grid[0][0]))
        visited[0][0] = true
        
        var maxTime = 0
        
        while (pq.isNotEmpty()) {
            val (row, col, elevation) = pq.poll()
            
            
            maxTime = maxOf(maxTime, elevation)
            
           
            if (row == n - 1 && col == n - 1) {
                return maxTime
            }
            
            
            for (dir in dirs) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]
                
                
                if (newRow in 0 until n && 
                    newCol in 0 until n && 
                    !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true
                    pq.offer(Triple(newRow, newCol, grid[newRow][newCol]))
                }
            }
        }
        
        return maxTime 
    }
}