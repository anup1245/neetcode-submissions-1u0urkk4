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
        return calculate(root, root?.`val` ?:0)
    }

    fun calculate(root: TreeNode?,max: Int):Int{
        if(root == null){
            return 0
        }

       val res = if(root!!.`val` >= max) {
            1
        } else 0
        return calculate(root.left ,Math.max(max, root!!.`val`)) + calculate(root.right, Math.max(max, root!!.`val`))+res
        
    }
}
