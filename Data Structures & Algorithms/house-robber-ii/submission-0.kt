class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        }
        if(nums.size == 2) {
            return maxOf(nums[0],nums[1])
        }
        val array1 = IntArray(nums.size-1)
        array1[0] = nums[0]
        array1[1] = maxOf(nums[0],nums[1])
        for(i in 2 until nums.size-1) {
            array1[i] = maxOf(array1[i-1], array1[i-2]+nums[i])
        }

        val array2 = IntArray(nums.size - 1)
        array2[0] = nums[1]
        array2[1] = maxOf(nums[1], nums[2])
        for (i in 2 until nums.size - 1) {
            array2[i] = maxOf(array2[i - 1], array2[i - 2] + nums[i + 1])
        }


        return maxOf(array1[array1.size-1], array2[array2.size-1])
    }
}
