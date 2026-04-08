class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {

        val left = IntArray(nums.size)
        val right = IntArray(nums.size)
        
        left[0] = 1
        for(i in 1 until nums.size) {
            left[i] = left[i - 1]* nums[i-1]
        }

        for(a in left) {
            System.out.println(a)
        }
        
        right[nums.size - 1] = 1
        for (i in nums.size - 2 downTo 0) {
            right[i] = right[i+1]* nums[i+1]
        }



        val result = IntArray(nums.size)
        for(i in 0 until nums.size) {
            result[i]= left[i]*right[i]
        }
        return result



    }
}
