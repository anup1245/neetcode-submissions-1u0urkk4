class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if(cost.size == 1) {
            return cost[0]
        }
        if(cost.size == 2) {
            return minOf(cost[1], cost[0])
        }

        val array = ArrayList<Int>()
        array.add(cost[0])
        array.add(minOf(cost[1], cost[1] + cost[0]))
        for(i in 2 until cost.size) {
           val first = array[i-1] + cost[i]
           val second = cost[i]+array[i-2]
           array.add(minOf(first, second))
           
        }
        return minOf(array.get(array.size -1), array.get(array.size -2))
    }
}
