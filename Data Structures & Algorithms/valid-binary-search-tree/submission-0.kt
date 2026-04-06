/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun valid(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true
        if (root.`val` <= min || root.`val` >= max) return false
        return valid(root.left, min, root.`val`.toLong()) &&
               valid(root.right, root.`val`.toLong(), max)
    }
}
