/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var longestPath = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        height(root)
        return longestPath
    }

    fun height(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }

        val left = height(root.left)
        val right = height(root.right)
        longestPath = Math.max(left + right, longestPath)
        return 1+ Math.max(left,right)
    }
}
