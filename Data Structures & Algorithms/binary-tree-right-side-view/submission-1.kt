/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {

        val result = mutableListOf<Int>()
        dfs(root, 0, result)
        return result
    }

    private fun dfs(node: TreeNode?, level: Int, result: MutableList<Int>) {
        if (node == null) return

        if (level == result.size) {
            result.add(node.`val`)
        }

        dfs(node.right, level + 1, result)
        dfs(node.left, level + 1, result)

    }
}
