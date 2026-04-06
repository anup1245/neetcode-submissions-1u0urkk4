class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()
        result.add(intervals[0])

        for (i in 1 until intervals.size) {
            if (result.last()[1] >= intervals[i][0]) {
                result.last()[1] = maxOf(result.last()[1], intervals[i][1])
            } else {
                result.add(intervals[i])
            }
        }

        return result.toTypedArray()
    }
}