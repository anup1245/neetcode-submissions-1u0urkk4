/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val cloneMap = HashMap<Int, Node>()
        val queue:Queue<Node> = LinkedList<Node>()

        if(node == null) {
            return null
        }

        val newNode = Node(node.`val`)
        cloneMap[node.`val`] = newNode
        queue.add(node)
        while(!queue.isEmpty()) {
            val temp = queue.poll()
            for(a in temp.neighbors) {
                if(!cloneMap.containsKey(a?.`val`)) {
                    val newTemp = Node(a!!.`val`)
                    cloneMap[newTemp.`val`] = newTemp
                    cloneMap[temp.`val`]?.neighbors?.add(newTemp)
                    queue.add(a)
                } else {
                    cloneMap[temp.`val`]?.neighbors?.add(cloneMap[a?.`val`])
                }
            }
        }
        return cloneMap[node.`val`]
    }
}
