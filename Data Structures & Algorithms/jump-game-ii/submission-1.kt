class Solution {
    fun jump(nums: IntArray): Int {
        var jumps =0
        var max = 0
        var current = 0

        for(i in 0 until nums.size-1) {
            max = maxOf(max, i+nums[i])
            if(i == current){
                jumps++
                current = max
            }
        }
        return jumps
    }
}
