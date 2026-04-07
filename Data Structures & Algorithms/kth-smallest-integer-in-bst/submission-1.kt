/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return inorder(root, intArrayOf(k))!!
    }

    private fun inorder(node: TreeNode?, k: IntArray): Int? {
        if (node == null) return null

        val left = inorder(node.left, k)
        if (left != null) return left

        k[0]--
        if (k[0] == 0) return node.`val`

        return inorder(node.right, k)
    }
}
