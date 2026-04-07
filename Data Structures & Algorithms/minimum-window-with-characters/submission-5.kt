class Solution {
    fun minWindow(s: String, t: String): String {
        var left = 0
        var right = 0
        var max = Integer.MAX_VALUE
        val map = HashMap<Char, Int>()
        val window = HashMap<Char, Int>()
        var match = 0
        var result = ""
        for(c in t) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        while(right < s.length) {
            val c = s[right]
            if(map.containsKey(c)) {
                window[c] = window.getOrDefault(c, 0) + 1
                if(window[c]!! == map[c]!!) match++
            }

            while(match == map.size) {
                if(right - left + 1 < max) {
                    max = right - left + 1
                    result = s.substring(left, right +1)
                }

                val c = s[left]
               if(map.containsKey(c)) {
                    window[c] = window.getOrDefault(c, 0) - 1
                    if(window[c]!! < map[c]!!) match--
                    if(window[c]!! == 0) {
                        window.remove(c)
                    }
               }
               left++
            }
            right++
        }
        return result
    }
}
