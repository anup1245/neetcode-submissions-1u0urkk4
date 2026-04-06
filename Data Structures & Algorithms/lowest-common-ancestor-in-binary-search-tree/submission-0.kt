/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null) {
            return null
        }

        if(root?.`val` == p?.`val` || root?.`val` == q?.`val`) {
            return root
        }

        if((root!!.`val` >= p!!.`val` && root!!.`val` <= q!!.`val`) || (root!!.`val` <= p!!.`val` && root!!.`val` >= q!!.`val`)) {
            return root
        }

        if(root!!.`val` > p!!.`val` && root!!.`val` > q!!.`val`) {
          return lowestCommonAncestor(root.left, p,q)
        } else {
           return lowestCommonAncestor(root.right, p,q)
        }
    }


}
