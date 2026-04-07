/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var prev: Long? = null

    fun isValidBST(root: TreeNode?): Boolean {
        return inorder(root)
    }

    private fun inorder(node: TreeNode?): Boolean {
        if (node == null) return true

        if (!inorder(node.left)) return false

        if (prev != null && node.`val` <= prev!!) return false
        prev = node.`val`.toLong()

        return inorder(node.right)

    }
}
