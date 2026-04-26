class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        val array = IntArray(n) {0}
        if(n == 1) {
            return cost[0]
        }

        if(n==2) {
            return minOf(cost[0], cost[1])
        }
        array[0] = cost[0]
        array[1] = minOf(cost[1], cost[1] + cost[0])
        for(i in 2 until n) {
            val first = array[i-1] + cost[i]
            val second = cost[i]+array[i-2]
            array[i] = minOf(minOf(first, second))
        }
        return minOf(array.get(array.size -1), array.get(array.size -2))
    }
}
