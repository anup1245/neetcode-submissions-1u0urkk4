class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        var l = 0
        var r = 0
        val q = ArrayDeque<Int>()

        val size = nums.size
        val result = mutableListOf<Int>()
        while(r<size) {
            while(q.isNotEmpty() && nums[q.last()] < nums[r]){
                q.removeLast()
            }
            q.addLast(r)
            r++

            if(q.isNotEmpty() && q.first() < l) {
                q.removeFirst()
            }

            if(r-l >= k) {
                result.add(nums[q.first()])
                l++
            }
        }
        return result.toIntArray()
    }
}
