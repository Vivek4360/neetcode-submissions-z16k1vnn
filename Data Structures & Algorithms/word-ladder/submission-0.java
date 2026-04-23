class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert wordList to HashSet for O(1) lookup operations
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If endWord is not in the wordList, no transformation sequence exists
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        // Queue for BFS traversal
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        // Set to keep track of visited words (prevents cycles)
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        // Level starts at 1 because we count the beginWord as step 1
        int level = 1;
        
        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all words at the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // If we've reached the endWord, return current level
                if (currentWord.equals(endWord)) {
                    return level;
                }
                
                // Try changing each character position
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    // Try all possible 26 lowercase letters
                    for (char c = 'a'; c <= 'z'; c++) {
                        // Skip if it's the same character
                        if (c == originalChar) {
                            continue;
                        }
                        
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        
                        // If the new word is in our wordSet and hasn't been visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    
                    // Restore the original character for the next position
                    wordChars[j] = originalChar;
                }
            }
            
            // Move to next level
            level++;
        }
        
        // If we exhaust all possibilities without finding endWord
        return 0;
    }
}