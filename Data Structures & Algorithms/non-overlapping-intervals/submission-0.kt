class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1] }
        var res = 0
        var end = Int.MIN_VALUE

        for (interval in intervals) {
            if (end <= interval[0]) {
                end = interval[1]   // no overlap — keep, update end
            } else {
                res++               // overlap — remove
            }
        }

        return res
    }
}