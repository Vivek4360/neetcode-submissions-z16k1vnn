/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

       var current = root

        
        val pv = p!!.`val`
        val qv = q!!.`val`

        while (current != null) {
            if (pv < current.`val` && qv < current.`val`) {
                current = current.left
            } else if (pv > current.`val` && qv > current.`val`) {
                current = current.right
            } else {
                return current
            }
        }
        return null

    }
}
