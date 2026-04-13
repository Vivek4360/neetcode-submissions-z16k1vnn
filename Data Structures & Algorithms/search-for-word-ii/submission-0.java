

class Solution {
    // Trie Node structure
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store complete word at end node
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        
        // Step 1: Build Trie
        TrieNode root = buildTrie(words);
        
        // Step 2: Search from each cell
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root, result);
            }
        }
        
        return result;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // Store word at end
        }
        
        return root;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        // Boundary and validity checks
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        
        char ch = board[i][j];
        
        // If cell is visited or character not in trie
        if (ch == '#' || node.children[ch - 'a'] == null) return;
        
        // Move to next node in trie
        node = node.children[ch - 'a'];
        
        // Check if we found a word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }
        
        // Mark cell as visited
        board[i][j] = '#';
        
        // Explore all 4 directions
        dfs(board, i + 1, j, node, result);
        dfs(board, i - 1, j, node, result);
        dfs(board, i, j + 1, node, result);
        dfs(board, i, j - 1, node, result);
        
        // Backtrack: restore cell
        board[i][j] = ch;
    }
}