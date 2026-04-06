/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var good = 0
    fun goodNodes(root: TreeNode?): Int {
        calculate(root, root?.`val` ?:0)
        return good
    }

    fun calculate(root: TreeNode?,max: Int) {
        if(root == null){
            return
        }

        if(root!!.`val` >= max) {
            good++
        }
        calculate(root.left ,Math.max(max, root!!.`val`))
        calculate(root.right, Math.max(max, root!!.`val`))
    }
}
