class PrefixTree {

    // Trie Node
    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var isEnd = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var node = root

        for (c in word) {
            val index = c - 'a'

            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }

            node = node.children[index]!!
        }

        node.isEnd = true
    }

    fun search(word: String): Boolean {
        val node = traverse(word)
        return node != null && node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        return traverse(prefix) != null
    }

    // Helper function
    private fun traverse(str: String): TrieNode? {
        var node = root

        for (c in str) {
            val index = c - 'a'

            if (node.children[index] == null) {
                return null
            }

            node = node.children[index]!!
        }

        return node
    }
}