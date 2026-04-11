class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val result = Collections.binarySearch(nums.toList(), target)
        return if(result < 0) -1 else result
    }
}
