class Solution {
    fun canJump(nums: IntArray): Boolean {
       var max = 0
       for(i in 0 until nums.size) {
        if(i > max) return false
        max = maxOf(max, i+nums[i])
       }
       return true
    }
}