class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        }
        if(nums.size == 2) {
            return maxOf(nums[0],nums[1])
        }
        val array = IntArray(nums.size)
        array[0] = nums[0]
        array[1] = maxOf(nums[0],nums[1])
        for(i in 2 until nums.size) {
            array[i] = maxOf(array[i-1], array[i-2]+nums[i])
        }
        return array[nums.size-1]
    }
}
