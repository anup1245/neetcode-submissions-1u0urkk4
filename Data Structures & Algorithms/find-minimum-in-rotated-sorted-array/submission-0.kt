class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var result = nums[0]

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                result = minOf(result, nums[l])
                break
            }
            val mid = l + (r - l) / 2
            result = minOf(result, nums[mid])
            if (nums[mid] >= nums[l]) {
                // left side is sorted, min must be on right
                l = mid + 1
            } else {
                // right side is sorted, min is on left (including mid)
                r = mid - 1
            }
        }
        return result
    }
}