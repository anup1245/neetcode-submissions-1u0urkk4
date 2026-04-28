/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var max = Integer.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        depth(root)
        return max
    }

     fun depth(root:TreeNode?): Int {
        if(root == null) {
            return 0
        }

        val left = maxOf(depth(root?.left),0)
        val right = maxOf(depth(root?.right),0)

        max = maxOf(max, root?.`val`?.plus(left)?.plus(right) ?: 0)

        return root?.`val`?.plus(maxOf(left, right)) ?: 0
    }
}
