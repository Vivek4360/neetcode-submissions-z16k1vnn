class Solution {
    private class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var word: String? = null
        var childCount = 0
    }
    
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val root = buildTrie(words)
        
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, i, j, root, result)
            }
        }
        
        return result
    }
    
    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode()
        
        words.forEach { word ->
            var node = root
            word.forEach { ch ->
                val index = ch - 'a'
                if (node.children[index] == null) {
                    node.children[index] = TrieNode()
                    node.childCount++
                }
                node = node.children[index]!!
            }
            node.word = word
        }
        
        return root
    }
    
    private fun dfs(
        board: Array<CharArray>, 
        i: Int, 
        j: Int, 
        node: TrieNode?, 
        result: MutableList<String>
    ): Boolean {
        // Boundary checks
        if (i !in board.indices || j !in board[0].indices) return false
        
        val ch = board[i][j]
        if (ch == '#' || node == null) return false
        
        val index = ch - 'a'
        val nextNode = node.children[index] ?: return false
        
        // Found a word
        nextNode.word?.let { word ->
            result.add(word)
            nextNode.word = null
        }
        
        // Mark as visited
        board[i][j] = '#'
        
        // Explore all 4 directions
        var found = false
        found = found or dfs(board, i + 1, j, nextNode, result)
        found = found or dfs(board, i - 1, j, nextNode, result)
        found = found or dfs(board, i, j + 1, nextNode, result)
        found = found or dfs(board, i, j - 1, nextNode, result)
        
        // Restore cell
        board[i][j] = ch
        
        // Optimization: Remove leaf nodes
        if (nextNode.childCount == 0) {
            node.children[index] = null
            node.childCount--
        }
        
        return found
    }
}