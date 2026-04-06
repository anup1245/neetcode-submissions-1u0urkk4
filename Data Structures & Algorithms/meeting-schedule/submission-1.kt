/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
    val sorted = intervals.sortedBy { it.start }

    for (i in 1 until sorted.size) {
        if (sorted[i - 1].end > sorted[i].start) {
            return false  // previous meeting ends after next one starts
        }
    }
    return true
}
}
