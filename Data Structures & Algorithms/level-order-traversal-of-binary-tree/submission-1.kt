/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()

            repeat(size) {
                val node = queue.poll()
                level.add(node.`val`)

                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            result.add(level)
        }

        return result
        

    }
}
