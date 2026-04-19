class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val map = TreeMap<Int, Int>()

        for(n in hand) {
            map[n] = map.getOrDefault(n,0)+1
        }

        while(map.isNotEmpty()) {
            val value = map.firstKey()
            for(j in value until value + groupSize) {
                if(map[j] == null) return false
                map[j] = map[j]!! - 1
                if(map[j]!! <= 0) {
                    map.remove(j)
                }
            }
        }
        return true
    }
}
