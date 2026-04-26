class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1

        var max = 0

        while(left<right) {
            val temp = minOf(heights[left], heights[right]) * (right - left)
            max = maxOf(temp, max)
            if(heights[left] < heights[right]) {
                left++
            } else {
                right--
            }
        }
        return max
    }
}
