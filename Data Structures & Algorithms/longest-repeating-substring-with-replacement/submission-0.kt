class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var right = 0
        val map = HashMap<Char,Int>()
        val size = s.length
        var maxfreq = 0
        var max = 0
        while(right < size) {
            map[s[right]] = map.getOrDefault(s[right], 0) + 1
            maxfreq = maxOf(maxfreq, map[s[right]]!!)

            while(right - left + 1 - maxfreq > k) {
                map[s[left]] = map[s[left]]!! - 1
                left++
            }

            max = maxOf(max, right - left + 1)
            right++
        }
        return max
    }
}
