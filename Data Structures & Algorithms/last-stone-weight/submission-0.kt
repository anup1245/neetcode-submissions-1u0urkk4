class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(reverseOrder())
        for (num in stones) pq.add(num)

        while(pq.size > 1) {
            val a = pq.poll()
            val b = pq.poll()
            val temp = a - b
            if(temp!=0) {
                pq.add(temp)
            }
        }
        return if(pq.size > 0) pq.peek() else 0
    }
}
