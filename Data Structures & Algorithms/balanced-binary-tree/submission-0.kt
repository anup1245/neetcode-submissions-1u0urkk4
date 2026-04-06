/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var isBalanced = true
    fun isBalanced(root: TreeNode?): Boolean {
        height(root)
        return isBalanced
    }

    fun height(root: TreeNode?): Int {
        if(root == null || isBalanced == false) {
            return 0
        }

        val left = height(root.left)
        val right = height(root.right)
        if(Math.abs(left - right)>1) {
            isBalanced = false
        }
        return 1+ Math.max(left,right)
    }
}
