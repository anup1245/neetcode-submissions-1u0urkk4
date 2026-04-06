class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()

        for (point in nums) pq.add(point)
        while(pq.size > k) {
            pq.poll()
        }
        return pq.peek()  // poll k smallest directly
    }
}
