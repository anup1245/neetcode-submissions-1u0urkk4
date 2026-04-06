/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var isSubTree = false
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        findSubRoot(root, subRoot)
        return isSubTree
    }

    fun findSubRoot(root: TreeNode?, subRoot: TreeNode?) {
        if(root == null || isSubTree) {
            return 
        }
        if(root?.`val` == subRoot?.`val`) {
            if(isSameTree(root, subRoot)) {
                isSubTree = true
            }
        }

        findSubRoot(root.left, subRoot)
        findSubRoot(root.right, subRoot)
    }

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
