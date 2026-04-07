/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        dfs(root, sb)
        return sb.toString()
    }

    private fun dfs(node: TreeNode?, sb: StringBuilder) {
        if (node == null) {
            sb.append("null,")
            return
        }

        sb.append("${node.`val`},")
        dfs(node.left, sb)
        dfs(node.right, sb)
    }

    // Deserialize
    fun deserialize(data: String): TreeNode? {
        val queue: Queue<String> = LinkedList(data.split(","))
        return buildTree(queue)
    }

    private fun buildTree(queue: Queue<String>): TreeNode? {
        val value = queue.poll()

        if (value == "null") return null

        val node = TreeNode(value.toInt())
        node.left = buildTree(queue)
        node.right = buildTree(queue)

        return node

    }
}
