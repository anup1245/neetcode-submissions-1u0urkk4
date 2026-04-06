class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort() 
        val results = mutableListOf<List<Int>>()
        backtrack(candidates, 0, ArrayList(), 0, target, results)
        return results
    }

    fun backtrack(nums: IntArray, 
                    start: Int, 
                    temp: MutableList<Int>, 
                    sum:Int, 
                    target: Int,
                    results: MutableList<List<Int>>) {
        if(sum > target) {
            return
        }        
        if(sum == target) {        
            results.add(ArrayList(temp))  
            return
        }
        for (i in start until nums.size) {
            // skip duplicates at same level
            if (i > start && nums[i] == nums[i - 1]) continue

            temp.add(nums[i])
            backtrack(nums, i + 1, temp, sum + nums[i], target, results)  // i+1 no reuse
            temp.removeAt(temp.size - 1)
        }
    }
}
