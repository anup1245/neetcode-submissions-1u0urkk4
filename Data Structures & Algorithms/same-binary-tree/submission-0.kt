/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if((p== null && q!= null) || (p!= null && q== null) || (p?.`val` != q?.`val`)) {
            return false
        }
        if(p == null && q == null) {
            return true
        }
       return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}
