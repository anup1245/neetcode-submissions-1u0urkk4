class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1

        if (nums[l] <= nums[r]) return nums[0] // not rotated

        while (l <= r) {
            val mid = l + (r - l) / 2
            if (mid + 1 < nums.size && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1]
            }
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid]
            }
            if (nums[mid] >= nums[0]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return nums[0]
    }
}