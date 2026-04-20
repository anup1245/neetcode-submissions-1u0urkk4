class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
       val array = Array<Int>(26){0}
        for(t in tasks) {
            array[t-'A']++
        }
        array.sort()
        val max = array[25]-1
        var idle = max*n

        for(i in 0 until array.size-1) {
            idle-= minOf(array[i], max)
        }
        return if(idle > 0) idle+tasks.size else tasks.size
    }
}
