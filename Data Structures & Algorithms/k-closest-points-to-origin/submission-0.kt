class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray> { a, b ->
            val distA = sqrt((a[0] * a[0] + a[1] * a[1]).toDouble())
            val distB = sqrt((b[0] * b[0] + b[1] * b[1]).toDouble())
            distA.compareTo(distB)
        }

        for (point in points) pq.add(point)

        return Array(k) { pq.poll() }  // poll k smallest directly
    }
}