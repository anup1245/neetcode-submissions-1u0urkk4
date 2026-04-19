class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize != 0) return false

        val map = TreeMap<Int, Int>()
        for (n in hand) {
            map[n] = (map[n] ?: 0) + 1
        }

        while (map.isNotEmpty()) {
            val start = map.firstKey()
            for (i in start until start + groupSize) {
                val count = map[i] ?: return false
                if (count == 1) {
                    map.remove(i)
                } else {
                    map[i] = count - 1
                }
            }
        }

        return true
    }
}