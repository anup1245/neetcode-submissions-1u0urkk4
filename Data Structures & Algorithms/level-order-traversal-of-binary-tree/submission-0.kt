/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
    val q: Queue<TreeNode> = LinkedList<TreeNode>()

    if (root != null) q.add(root)

    while (q.isNotEmpty()) {
        val list = mutableListOf<Int>()
        val size = q.size  // property, not method
        repeat(size) {
            val node = q.poll()!!
            list.add(node.`val`)
            if (node.left != null) q.add(node.left)
            if (node.right != null) q.add(node.right)
        }
        result.add(list)
    }

    return result
    }
}
