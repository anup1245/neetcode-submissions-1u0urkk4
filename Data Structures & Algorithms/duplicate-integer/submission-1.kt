class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = HashSet<Int>()
        for(num in nums) {
            if(map.contains(num)){
                return true
            }
            map.add(num)
        }
        return false
    }
}
