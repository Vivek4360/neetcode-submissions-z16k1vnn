class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        // Convert wordList to HashSet for O(1) lookup operations
        val wordSet = wordList.toHashSet()
        
        // If endWord is not in the wordList, no transformation sequence exists
        if (endWord !in wordSet) {
            return 0
        }
        
        // Queue for BFS traversal
        val queue: Queue<String> = LinkedList()
        queue.offer(beginWord)
        
        // Set to keep track of visited words (prevents cycles)
        val visited = mutableSetOf(beginWord)
        
        // Level starts at 1 because we count the beginWord as step 1
        var level = 1
        
        // BFS loop
        while (queue.isNotEmpty()) {
            val size = queue.size
            
            // Process all words at the current level
            repeat(size) {
                val currentWord = queue.poll()
                
                // If we've reached the endWord, return current level
                if (currentWord == endWord) {
                    return level
                }
                
                // Try changing each character position
                val wordChars = currentWord.toCharArray()
                for (j in wordChars.indices) {
                    val originalChar = wordChars[j]
                    
                    // Try all possible 26 lowercase letters
                    for (c in 'a'..'z') {
                        // Skip if it's the same character
                        if (c == originalChar) {
                            continue
                        }
                        
                        wordChars[j] = c
                        val newWord = String(wordChars)
                        
                        // If the new word is in our wordSet and hasn't been visited
                        if (newWord in wordSet && newWord !in visited) {
                            queue.offer(newWord)
                            visited.add(newWord)
                        }
                    }
                    
                    // Restore the original character for the next position
                    wordChars[j] = originalChar
                }
            }
            
            // Move to next level
            level++
        }
        
        // If we exhaust all possibilities without finding endWord
        return 0
    }
}