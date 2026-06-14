/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // 1. Find middle
        var slow = head
        var fast = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        // 2. Reverse second half
        var prev: ListNode? = null
        var curr = slow?.next
        slow?.next = null // cut the list
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }

        // 3. Merge two halves: head and prev
        var first = head
        var second = prev
        while (second != null) {
            val tmp1 = first?.next
            val tmp2 = second.next
            first?.next = second
            second.next = tmp1
            first = tmp1
            second = tmp2
        }
    }
}