class Solution {
    fun maxSubArray(nums: IntArray): Int {
         var max = nums.max()
         var i=0
         var sum = 0
         while(i<nums.size) {
            var j=i
            while(sum >= 0 && j < nums.size) {
                sum+=nums[j]
                j++
                max = maxOf(max, sum)
            }
             sum = 0
             i = j
            }
            return max
         }
    
}
