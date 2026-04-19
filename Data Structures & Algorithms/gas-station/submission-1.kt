class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var start = 0
        var totalTank = 0
        var current = 0

        for(i in 0 until gas.size) {
            val diff = gas[i] - cost[i]
            totalTank+=diff
            current+=diff

            if(current < 0) {
                start = i+1
                current = 0
            }
        }
        return if(totalTank>=0) start else -1
    }
}
