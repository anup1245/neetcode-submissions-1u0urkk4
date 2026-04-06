class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val n = intervals.size
        var i = 0
        val list = mutableListOf<IntArray>()
        var new = newInterval

        // add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < new[0]) {
            list.add(intervals[i])
            i++
        }

        // merge all overlapping intervals
        while (i < n && intervals[i][0] <= new[1]) {
            new[0] = minOf(intervals[i][0], new[0])
            new[1] = maxOf(intervals[i][1], new[1])
            i++
        }
        list.add(new)

        // add remaining intervals
        while (i < n) {
            list.add(intervals[i])
            i++
        }

        return list.toTypedArray()
    }
}