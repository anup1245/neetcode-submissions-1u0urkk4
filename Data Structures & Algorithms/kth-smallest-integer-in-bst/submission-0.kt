/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var list = ArrayList<Int>()
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root)
        return list.get(k-1)
    }

    fun inorder(root: TreeNode?) {
        if(root == null) {
            return
        }
        inorder(root.left)
        list.add(root!!.`val`)
        inorder(root.right)
    }
}
