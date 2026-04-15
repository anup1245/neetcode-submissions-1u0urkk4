class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var array = IntArray(nums.size){ 1 }


        for(i in nums.size - 1 downTo 0) {
            for(j in i+1 until nums.size) {
                if(nums[i] < nums[j]) {
                    array[i] = maxOf(array[i], 1 + array[j])
                }
            }
        }
        return array.max()
    }
}
