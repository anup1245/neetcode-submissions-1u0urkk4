class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int,Int>()

        for(i in 0 until nums.size) {
            val temp = target - nums[i]
            if(map.contains(temp)) {
                return intArrayOf(map[temp]!!, i)
            } else {
                map[nums[i]] = map.getOrPut(nums[i], {i})
            }
        }
        return intArrayOf(0)
    }
}
