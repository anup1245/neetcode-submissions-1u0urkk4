class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        for(n in nums) {
            if(set.contains(n)) {
                return true
            }
            set.add(n)
        }
        return false
    }
}
