class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort() 
        val results = mutableListOf<List<Int>>()
        backtrack(nums, 0, ArrayList(), results)
        return results
    }

    fun backtrack(nums: IntArray, 
                    start: Int, 
                    temp: MutableList<Int>, 
                    results: MutableList<List<Int>>) {
        
        results.add(ArrayList(temp)) 
        for (i in start until nums.size) {
            // skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) continue
            temp.add(nums[i])
            backtrack(nums, i + 1, temp, results)  // i+1 no reuse
            temp.removeAt(temp.size - 1)
        }
    }
}
