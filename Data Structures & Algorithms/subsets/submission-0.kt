class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        backtrack(nums, 0, ArrayList(), results)
        return results
    }

    fun backtrack(nums: IntArray, start: Int, temp: MutableList<Int>, results: MutableList<List<Int>>) {
        results.add(ArrayList(temp))  // snapshot of current subset
        for (i in start until nums.size) {
            temp.add(nums[i])
            backtrack(nums, i + 1, temp, results)  // i+1 avoid reuse
            temp.removeAt(temp.size - 1)            // backtrack
        }
    }
}