class KthLargest(val k: Int, nums: IntArray) {
    val pq = PriorityQueue<Int>()

    init {
        for (num in nums) pq.add(num)
        while (pq.size > k) pq.poll()  // ← size not size()
    }

    fun add(value: Int): Int {
        pq.add(value)
        while (pq.size > k) pq.poll()  // ← size not size()
        return pq.peek()
    }
}
