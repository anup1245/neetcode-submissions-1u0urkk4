class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right =height.size -1
        var sum = 0
        var maxr = 0
        var maxl=0

        while(left < right) {
            if(height[left] <= height[right]) {
                if(maxl < height[left]){
                    maxl = height[left]
                } else {
                    sum = sum + (maxl - height[left])
                }
                left++
            } else {
                if(maxr < height[right]){
                    maxr = height[right]
                } else {
                    sum = sum + (maxr - height[right])
                }
                right--
            }
        }
        return sum
    }
}
