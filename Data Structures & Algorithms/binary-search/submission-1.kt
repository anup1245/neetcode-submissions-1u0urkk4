class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1
        var result = -1

        while(left<=right) {
            var mid = left + (right - left) / 2
            if(nums[mid] == target) {
                return mid
            } else if(target < nums[mid]) {
                right = mid-1
            } else {
                left = mid+1
            }
        }
        return result
    }
}
