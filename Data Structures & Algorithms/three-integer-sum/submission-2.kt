class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
         nums.sort()
         val result = ArrayList<List<Int>>()
         for(i in 0 until nums.size) {
            if( i >= 1 && nums[i] == nums[i-1]) {
                continue
            }
            var left = i+1
            var right = nums.size-1
            val c = nums[i]
            while(left<right) {
                val a = nums[left]
                val b = nums[right]
                val temp = a+b+c            //-4,-1,-1,0,1,2
                if(temp == 0) {
                    result.add(listOf(c, a, b))
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) left++   // skip dup lefts
                    while (left < right && nums[right] == nums[right + 1]) right--
                } else if(temp > 0) {
                    right--
                } else {
                    left++
                }
            }
         }
         return result

    }
}
