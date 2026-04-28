class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Build graph and in-degree map
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Initialize maps with all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build edges from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check for invalid case: word1 is prefix of word2 but longer
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            // Find first different character
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    // Add edge c1 -> c2 if not already present
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        // Step 3: Topological sort using BFS (Kahn's algorithm)
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            
            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // If we couldn't process all characters, there's a cycle
        return result.length() != inDegree.size() ? "" : result.toString();
    }
}