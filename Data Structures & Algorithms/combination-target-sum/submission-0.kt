class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        backtrack(nums, 0, ArrayList(), 0, target, results)
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
        }
        for (i in start until nums.size) {
            temp.add(nums[i])
            backtrack(nums, i, temp, sum+nums[i], target, results)  
            temp.removeAt(temp.size - 1)            
        }
    }
}
