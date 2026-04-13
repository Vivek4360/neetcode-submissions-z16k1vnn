class WordDictionary {
    private TrieNode root;
    
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        
        char ch = word.charAt(index);
        
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (searchHelper(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int childIndex = ch - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            return searchHelper(word, index + 1, node.children[childIndex]);
        }
    }
}