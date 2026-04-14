class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow: ListNode? = dummy

        // Move fast n+1 steps ahead
        for (i in 0..n) {
            fast = fast?.next
        }

        // Move both until fast hits null
        while (fast != null) {
            fast = fast.next
            slow = slow?.next
        }

        // slow is now one before the node to remove
        slow?.next = slow?.next?.next

        return dummy.next
    }
}