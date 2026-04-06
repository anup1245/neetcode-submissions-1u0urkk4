class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        val set = HashSet<Char>()
        var maxLen = 0

        while (right < s.length) {
            val c = s[right]
            while (set.contains(c)) {
                set.remove(s[left])
                left++
            }
            set.add(c)
            maxLen = maxOf(maxLen, right - left + 1)
            right++
        }
        return maxLen
    }
}