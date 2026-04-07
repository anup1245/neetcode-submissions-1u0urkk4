class Solution {
    fun checkInclusion(t: String, s: String): Boolean {
        if (t.length > s.length) return false

        val map = HashMap<Char, Int>()
        val window = HashMap<Char, Int>()
        var match = 0
        var left = 0

        for (c in t) map[c] = map.getOrDefault(c, 0) + 1

        for (right in s.indices) {
            val r = s[right]

            // add right char to window
            if (map.containsKey(r)) {
                window[r] = window.getOrDefault(r, 0) + 1
                if (window[r]!! == map[r]!!) match++
            }

            // window exceeded t.length — remove left char
            if (right - left + 1 > t.length) {
                val l = s[left]
                if (map.containsKey(l)) {
                    if (window[l]!! == map[l]!!) match--  // losing a match
                    window[l] = window[l]!! - 1
                    if (window[l] == 0) window.remove(l)
                }
                left++
            }

            if (match == map.size) return true
        }

        return false
    }
}