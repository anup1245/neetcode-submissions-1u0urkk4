class Solution {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size) {0}
        val right = IntArray(height.size) {0}

        var max = 0
        
        for(i in 1 until height.size) {
            left[i] = maxOf(left[i-1], height[i-1])
        }

        for(i in height.size-2 downTo 0) {
            right[i] = maxOf(right[i+1], height[i+1])
        }


        for(i in 0 until height.size) {
            max += maxOf(0, minOf(left[i], right[i]) - height[i])
        }
        return max
    }
}
