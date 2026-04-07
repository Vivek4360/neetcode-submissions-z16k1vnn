/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return maxSum
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val left = maxOf(0, dfs(node.left))
        val right = maxOf(0, dfs(node.right))

        // Path passing through node
        val currentPath = left + node.`val` + right

        maxSum = maxOf(maxSum, currentPath)

        // Return best single path
        return node.`val` + maxOf(left, right)

    }
}
