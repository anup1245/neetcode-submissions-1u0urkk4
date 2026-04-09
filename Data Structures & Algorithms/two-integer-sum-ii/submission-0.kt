class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size-1

        while(left<right) {
            val a = numbers[left]
            val b = numbers[right]
            val temp = a+b
            if(temp == target) {
                return intArrayOf(left+1, right+1)
            } else if(temp > target) {
                right--
            } else {
                left++
            }
        }
        return intArrayOf()
    }
}
