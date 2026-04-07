/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var preIndex = 0
    private lateinit var inorderMap: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorderMap = inorder.withIndex().associate { it.value to it.index }
        return helper(preorder, 0, inorder.size - 1)
    }

    private fun helper(preorder: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null

        val rootVal = preorder[preIndex++]
        val root = TreeNode(rootVal)

        val mid = inorderMap[rootVal]!!

        root.left = helper(preorder, left, mid - 1)
        root.right = helper(preorder, mid + 1, right)

        return root

    }
}
