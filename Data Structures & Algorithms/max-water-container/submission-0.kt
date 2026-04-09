class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size-1
        var max = 0

        while(left < right) {
            var lh = heights[left]
            var rh = heights[right]

            val min = minOf(lh, rh)
            max = maxOf(max, min* (right - left))

            if(lh > rh) {
                right--
            } else {
                left++
            }
        }
        return max
    }
}
