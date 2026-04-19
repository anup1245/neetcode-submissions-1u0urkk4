class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var max = -1
        for(n in nums) {
            max = maxOf(n, max)
        }

        for(i in 0 until nums.size) {
         if(nums[i] > max) {
            val actualValue = Math.abs(max - nums[i])
            if(nums[actualValue - 1] > max) {
                return actualValue
            } else {
                nums[actualValue - 1] = nums[actualValue - 1] + max
            }
         } else {
            val index = Math.abs(nums[i]-1)
            if(nums[index] > max) {
                return nums[i]
            }
            nums[index] = nums[index] + max
         }
         
        }
        return -1
    }
}
