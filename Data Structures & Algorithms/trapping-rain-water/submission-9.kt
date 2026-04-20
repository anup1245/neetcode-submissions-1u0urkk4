class Solution {
    fun trap(height: IntArray): Int {
        var left =IntArray(height.size){0}
        var right =IntArray(height.size){0}

        left[0] = height[0]
        right[height.size - 1] = height[height.size-1]
        
        for(i in 1 until height.size) {
            left[i] = maxOf(left[i-1], height[i])
        }

        for(i in height.size-2 downTo 0) {
            right[i] = maxOf(right[i+1], height[i])
        }

        var sum = 0
        for(i in 0 until height.size) {
            sum+= minOf(left[i], right[i]) - height[i]
        }
        return sum

    }
}
