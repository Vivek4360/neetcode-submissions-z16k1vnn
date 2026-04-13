class WordDictionary {
    private val root = TrieNode()
    
    private class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var isEndOfWord = false
    }
    
    fun addWord(word: String) {
        var current = root
        
        for (ch in word) {
            val index = ch - 'a'
            
            if (current.children[index] == null) {
                current.children[index] = TrieNode()
            }
            current = current.children[index]!!
        }
        current.isEndOfWord = true
    }
    
    fun search(word: String): Boolean {
        return searchHelper(word, 0, root)
    }
    
    private fun searchHelper(word: String, index: Int, node: TrieNode?): Boolean {
        if (node == null) return false
        if (index == word.length) return node.isEndOfWord
        
        val ch = word[index]
        
        return if (ch == '.') {
            // Try all possible children for wildcard
            node.children.any { child ->
                child != null && searchHelper(word, index + 1, child)
            }
        } else {
            // Follow specific character path
            val childIndex = ch - 'a'
            searchHelper(word, index + 1, node.children[childIndex])
        }
    }
}