/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val q: Queue<TreeNode> = LinkedList<TreeNode>()

        if (root != null) q.add(root)

        while (q.isNotEmpty()) {
            val list = mutableListOf<Int>()
            val size = q.size
            var a = 0
            repeat(size) {
                val node = q.poll()!!
                if (node.left != null) q.add(node.left)
                if (node.right != null) q.add(node.right)
                if(a == size - 1) {
                    result.add(node.`val`)
                }
                a++
            }
        }

        return result
    }
}
