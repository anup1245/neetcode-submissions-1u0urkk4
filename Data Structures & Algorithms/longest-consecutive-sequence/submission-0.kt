class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val map = HashSet<Int>()
        for(num in nums) {
            map.add(num)
        }
        var max = 0
        for(num in nums) {
            if(map.contains(num-1)) {
                continue
            }
            var start = 1
            var temp = num
            while(true) {
                if(map.contains(temp+1)) {
                  start++
                  temp = temp+1
                } else {
                    break
                }
            }
            max = Math.max(max, start)
        }
        return max
    }
}
