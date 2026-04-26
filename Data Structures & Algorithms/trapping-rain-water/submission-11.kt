class Solution {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size) {0}
        val right = IntArray(height.size) {0}
        val n = height.size
        var max = 0
        left[0] = height[0]
        for(i in 1 until height.size) {
            left[i] = maxOf(left[i-1], height[i])
        }

        right[n - 1] = height[n - 1]
        for(i in height.size-2 downTo 0) {
            right[i] = maxOf(right[i+1], height[i])
        }


        for(i in 0 until height.size) {
            max += abs(minOf(left[i], right[i]) - height[i])
        }
        return max
    }
}
