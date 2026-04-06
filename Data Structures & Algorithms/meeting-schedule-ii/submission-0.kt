/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sorted = intervals.sortedBy { it.start }
        val pq = PriorityQueue<Int>()

        for(interval in sorted) {
            if(pq.isNotEmpty() && pq.peek() <= interval.start) {
                pq.poll()
            } 
                pq.add(interval.end)
            
        }
        return pq.size
    }
}
