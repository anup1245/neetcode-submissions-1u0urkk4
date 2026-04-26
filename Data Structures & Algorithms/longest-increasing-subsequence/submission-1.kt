class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for (i in 0 until nums.size) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }
        }
        return dp.max()
    }
}