class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val map = IntArray(26)
        val window = IntArray(26)

        for(i in 0 until s1.length){
            map[s1[i] - 'a']++
            window[s2[i] - 'a']++
        }

        if(Arrays.equals(map, window)) {
            return true
        }

        var left = 0

        for(right in s1.length until s2.length) {
            window[s2[right] - 'a']++
            window[s2[left] - 'a']--
            left++
            if(Arrays.equals(map, window)) {
                return true
            }

        }
        return false
    }
}
