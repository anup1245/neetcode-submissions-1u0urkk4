/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        val dummy = ListNode(-1)
        var tail = dummy

        val pq = PriorityQueue<ListNode>(compareBy { it.`val` })

        for (node in lists) {
            if (node != null) pq.offer(node)
        }

        while (pq.isNotEmpty()) {
            val curr = pq.poll()
            if (curr.next != null) pq.offer(curr.next)
            tail.next = ListNode(curr.`val`)
            tail = tail.next!!
        }

        return dummy.next
    }
}
