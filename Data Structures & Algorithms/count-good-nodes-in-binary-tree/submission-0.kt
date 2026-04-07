/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {

        if (root == null) return 0

    var count = 0
    // Stack holds pairs of (node, maxSoFar)
    val stack = ArrayDeque<Pair<TreeNode, Int>>()
    stack.addLast(root to Int.MIN_VALUE)

    while (stack.isNotEmpty()) {
        val (node, maxSoFar) = stack.removeLast()

        if (node.`val` >= maxSoFar) count++

        val newMax = maxOf(maxSoFar, node.`val`)
        node.left?.let  { stack.addLast(it to newMax) }
        node.right?.let { stack.addLast(it to newMax) }
    }

    return count
}
 }

