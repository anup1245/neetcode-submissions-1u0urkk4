class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxLeft = 0
        var maxRight = 0
        var sum = 0

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left]
                } else {
                    sum += maxLeft - height[left]
                }
                left++
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right]
                } else {
                    sum += maxRight - height[right]
                }
                right--
            }
        }

        return sum
    }
}