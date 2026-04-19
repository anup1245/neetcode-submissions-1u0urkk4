/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val map = HashMap<Node, Node>()

        var temp = head
        while(temp!=null) {
            map[temp] = Node(temp.`val`)
            temp = temp.next
        }

        temp = head
        while(temp!=null) {
            map[temp]!!.next = map[temp.next] ?: null
            map[temp]!!.random = map[temp.random] ?: null
            temp = temp.next
        }

        return map[head] ?: null
    }
}
