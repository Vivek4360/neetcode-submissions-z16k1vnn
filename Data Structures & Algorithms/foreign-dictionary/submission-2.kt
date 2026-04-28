class Solution {
    fun foreignDictionary(words: Array<String>): String {
        // Step 1: Build graph and in-degree map
        val graph = mutableMapOf<Char, MutableSet<Char>>()
        val inDegree = mutableMapOf<Char, Int>()
        
        // Initialize maps with all unique characters
        for (word in words) {
            for (c in word) {
                graph.putIfAbsent(c, mutableSetOf())
                inDegree.putIfAbsent(c, 0)
            }
        }
        
        // Step 2: Build edges from adjacent word pairs
        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]
            
            // Check for invalid case: word1 is prefix of word2 but longer
            if (word1.length > word2.length && word1.startsWith(word2)) {
                return ""
            }
            
            // Find first different character
            val minLen = minOf(word1.length, word2.length)
            for (j in 0 until minLen) {
                val c1 = word1[j]
                val c2 = word2[j]
                
                if (c1 != c2) {
                    // Add edge c1 -> c2 if not already present
                    if (c2 !in graph[c1]!!) {
                        graph[c1]!!.add(c2)
                        inDegree[c2] = inDegree[c2]!! + 1
                    }
                    break
                }
            }
        }
        
        // Step 3: Topological sort using BFS (Kahn's algorithm)
        val result = StringBuilder()
        val queue: java.util.Queue<Char> = java.util.LinkedList()
        
        // Add all nodes with in-degree 0
        for ((char, degree) in inDegree) {
            if (degree == 0) {
                queue.offer(char)
            }
        }
        
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            result.append(current)
            
            for (neighbor in graph[current]!!) {
                inDegree[neighbor] = inDegree[neighbor]!! - 1
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor)
                }
            }
        }
        
        // If we couldn't process all characters, there's a cycle
        return if (result.length != inDegree.size) "" else result.toString()
    }
}