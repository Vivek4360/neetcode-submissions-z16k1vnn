/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

        if (root == null) return false

        if (isSameTree(root, subRoot)) return true

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSameTree(a: TreeNode?, b: TreeNode?): Boolean {

        if (a == null && b == null) return true
        if (a == null || b == null) return false
        if (a.`val` != b.`val`) return false

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right)

    }
}
