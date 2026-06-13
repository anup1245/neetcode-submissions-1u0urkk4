class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val first = s.toCharArray()
        first.sort()

        val second = t.toCharArray()
        second.sort()

        val map = HashMap<Char, Int>()

        for(c in first) {
            map[c] = map.getOrDefault(c, 0)+1
        }

        for(c in second) {
            if(map.containsKey(c)){
                map[c] = map[c]!!-1
                if(map[c]!! <= 0) {
                    map.remove(c)
                }
            } else {
                return false
            }
        }
        return map.size == 0

    }
}
