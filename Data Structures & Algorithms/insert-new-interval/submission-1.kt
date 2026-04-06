class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var i=0
        val size = intervals.size

        val list = mutableListOf<IntArray>()

        while( i< size && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i])
            i++
        }

        while(i< size && intervals[i][0] <= newInterval[1]){
            newInterval[0] = minOf(intervals[i][0], newInterval[0])
            newInterval[1] = maxOf(intervals[i][1], newInterval[1])
            i++
        }

        list.add(newInterval)

        while(i<size) {
            list.add(intervals[i])
            i++
        }
        return list.toTypedArray()

    }
}
